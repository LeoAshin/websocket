package com.websocket.server;

import com.websocket.util.ChannelManager;
import com.websocket.util.PidUtil;
import com.websocket.util.PropertiesStr;
import com.websocket.util.redis.RedisShard;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 09:27
 */
public class HttpServer {

    private static Logger log = LoggerFactory.getLogger(HttpServer.class);
    private static String pid_path = "/data/WS/pid/pid";

    private void startInbound(int port) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.SO_RCVBUF, 1048576)
                    .childOption(ChannelOption.SO_SNDBUF, 1048576)
                    .childOption(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("http-codec", new HttpServerCodec());
                            ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                            ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
                            ch.pipeline().addLast(new WebScoketServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128);
            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws IOException {
        //init
        PropertiesStr propertiesStr = new PropertiesStr();
        propertiesStr.initProperties();
        PidUtil.pidfile(pid_path);
        RedisShard.initRedisShard();
        RedisShard.initJedisPool();
        ChannelManager channelManager = new ChannelManager();
        channelManager.initManager();

        Thread inbound = new Thread(new Runnable() {
            @Override
            public void run() {
                HttpServer serverIn = new HttpServer();
                log.info("HttpQueue inbound Server listening on " + PropertiesStr.inBound + " ...");
                try {
                    serverIn.startInbound(PropertiesStr.inBound);
                } catch (Exception e) {
                    log.error("Inbound Server crash!!!", e);
                    System.exit(1);
                }
            }
        });

        inbound.start();
    }
}
