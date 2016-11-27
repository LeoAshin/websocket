package com.websocket.service;

import io.netty.channel.ChannelHandlerContext;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 18:50
 */
public interface IMessagePushService {

    //消息单个推送
    String pushMsg(String context, String oUid);

    //推送未读消息
    String checkUnreadMsg(ChannelHandlerContext ctx);
}
