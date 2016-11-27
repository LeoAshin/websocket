package com.websocket.bean;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 09:34
 */
public class Global {
    //群发标签,现在暂时为未分组
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

}
