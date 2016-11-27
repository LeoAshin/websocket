package com.websocket.util;

import com.websocket.bean.Global;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 18:44
 */
public class MessageSender {

    private static Logger logger = LoggerFactory.getLogger(MessageSender.class);

    /**
     * 推送单个信息
     *
     * @param ctx
     * @param context
     */
    public static void pushMsg(ChannelHandlerContext ctx, String context) {
        logger.info("MessageSender.pushMsg context[{}]", context);
        TextWebSocketFrame tws = new TextWebSocketFrame(context);
        ctx.channel().writeAndFlush(tws);
    }

    /**
     * 群发信息
     *
     * @param context
     */
    public static void pushMsgToAll(String context) {
        TextWebSocketFrame tws = new TextWebSocketFrame(context);
        Global.group.writeAndFlush(tws);
    }
}
