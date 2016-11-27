package com.websocket.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.websocket.bean.Global;
import com.websocket.bean.protocolbean.InputHead;
import com.websocket.bean.protocolbean.JsonMessage;
import com.websocket.bean.protocolbean.Result;
import com.websocket.service.IMessagePushService;
import com.websocket.service.MessagePushService;
import com.websocket.util.*;
import com.websocket.util.redis.RedisShard;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;

import java.io.UnsupportedEncodingException;

import static com.google.common.net.HttpHeaders.CONTENT_LENGTH;
import static com.google.common.net.HttpHeaders.CONTENT_TYPE;


/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 09:41
 */
public class WebScoketServerHandler extends SimpleChannelInboundHandler<Object> {

    private Logger logger = LoggerFactory.getLogger(WebScoketServerHandler.class);

    private static final String pg = "com.websocket.controller.";
    //握手
    private WebSocketServerHandshaker handshaker;

    private IMessagePushService messagePushService = new MessagePushService();

    private static final String url = PropertiesStr.wsUrl;

    /**
     * 处理消息类
     * 需要判断是http请求还是websocket请求,从而进行判断
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof FullHttpRequest) {

            handleHttpRequest(ctx, ((FullHttpRequest) msg));

        } else if (msg instanceof WebSocketFrame) {
            handlerWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) throws UnsupportedEncodingException {
        if (!req.getDecoderResult().isSuccess()) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }

        String uri = req.getUri();
        Result result = new Result();

        if ("/queue".equals(uri)) {

            try {
                ByteBuf buf = req.content();
                buf.retain();
                String message = buf.toString(CharsetUtil.UTF_8);
                logger.debug("message is: [{}]", message);

                buf.release();

                JsonMessage jsonMessage = JSON.parseObject(message, JsonMessage.class);
                String head = jsonMessage.getHead();
                String body = jsonMessage.getBody();

                System.out.println(head);

                InputHead inputHead = JSON.parseObject(head, InputHead.class);
                String className = inputHead.getClassname();
                String classNameAll = pg + className;


                ClassReflect.classReflect(Class.forName(classNameAll), inputHead.getMethodname(), body, result);
            } catch (JSONException e) {
                result.setStatus(CommonConst.ONE_SHORT);
                result.setCode("Json Parse Error");
            } catch (Exception e) {
                logger.error("ClassReflect error", e);
                result.setCode(CommonConst.ERROR);
                result.setStatus(CommonConst.ONE_SHORT);
            }

            String res = JSON.toJSONString(result);
            logger.debug("res is [{}]", res);

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
            response.headers().set(CONTENT_TYPE, "text/plain");
            response.headers().set(CONTENT_LENGTH,
                    response.content().readableBytes());
            response.headers().set("Access-Control-Allow-Origin", "*");

            ctx.write(response);
            ctx.flush();

        } else {
            ShardedJedis shardedJedis = RedisShard.getJedisObject();
            String[] arr = uri.split("\\?");
            String id;
            if (arr.length > 1) {
                id = arr[1];
                logger.debug("ID[{}]-----------------------------",id);
                ChannelManager.add(id);
                String idKey = String.valueOf(System.currentTimeMillis());
                ChannelManager.put(idKey, ctx);
                shardedJedis.lpush(CommonConst.CHANNELS + CommonConst.SPLITOR + id, idKey);
                shardedJedis.hset(CommonConst.TIMESTAMPTOID, idKey, id);
            }
            RedisShard.returnJedisObject(shardedJedis);
            WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                    url, null, false);
            handshaker = wsFactory.newHandshaker(req);
            if (handshaker == null) {
                WebSocketServerHandshakerFactory
                        .sendUnsupportedWebSocketVersionResponse(ctx.channel());
            } else {
                handshaker.handshake(ctx.channel(), req);
                messagePushService.checkUnreadMsg(ctx);
            }

        }

    }

    /**
     * 判断活动连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Global.group.add(ctx.channel());
        System.out.println("已连接 ------------");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }


    /**
     * 判断连接的各种状况
     *
     * @param ctx
     * @param frame
     */
    private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {

        // 判断是否关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame
                    .retain());
            ShardedJedis shardedJedis = RedisShard.getJedisObject();
            ChannelManager.del(ctx, shardedJedis);
            RedisShard.returnJedisObject(shardedJedis);
            return;
        }
        // 判断是否ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(
                    new PongWebSocketFrame(frame.content().retain()));
            return;
        }

        //仅支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            logger.debug("binary message unsupport");
            return;
        }

        // 返回应答消息
        String request = ((TextWebSocketFrame) frame).text();
        logger.debug("server recieved message [{}]", request);


        TextWebSocketFrame tws = new TextWebSocketFrame(DateUtil.currentDate(CommonConst.DATEFORMAT3)
                + ctx.channel().id() + "：" + request);
        // 群发
        Global.group.writeAndFlush(tws);
        // 返回
//        ctx.channel().writeAndFlush(tws);
    }

    /**
     * 发送响应消息
     *
     * @param ctx
     * @param req
     * @param res
     */
    private static void sendHttpResponse(ChannelHandlerContext ctx,
                                         FullHttpRequest req, DefaultFullHttpResponse res) {
        // 返回应答给客户端
        if (res.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.getStatus().toString(),
                    CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        f.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
