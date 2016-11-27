package com.websocket.util;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 14:57
 */
public class ChannelManager {

    private static Logger logger = LoggerFactory.getLogger(ChannelManager.class);

    //用来存储连接的客户端的对应关系 key为时间戳, value为ctx
    private static Map<String, ChannelHandlerContext> treeMap;
    //存储存在未读的Id
    private static List<String> list;

    public void initManager() {
        treeMap = Maps.newTreeMap();
        list = Lists.newArrayList();

        treeReport();
    }

    public static void put(String Id, ChannelHandlerContext ctx) {
        logger.info("新增连接,连接标识[{}]--------------------", Id);
        treeMap.put(Id, ctx);

        treeReport();
    }

    public static void del(String uId) {
        treeMap.remove(uId);
    }

    public static void del(ChannelHandlerContext ctx, ShardedJedis shardedJedis) {

        if (treeMap.containsValue(ctx)) {
            Set<String> set = treeMap.keySet();

            synchronized (set) {
                for (String key : set) {
                    ChannelHandlerContext ctxIn = treeMap.get(key);
                    if (ctxIn == ctx) {
                        treeMap.remove(key);
                        String Id = shardedJedis.hget(CommonConst.TIMESTAMPTOID, key);
                        shardedJedis.lrem(CommonConst.CHANNELS + CommonConst.SPLITOR + Id, CommonConst.ZERO_LONG, key);
                        shardedJedis.hdel(CommonConst.TIMESTAMPTOID, key);
                        logger.debug("连接Id为[{}]已被关闭------------------------", Id);
                        break;
                    }
                }
            }
        }
        treeReport();
    }

    public static boolean exist(String id) {
        return list.contains(id);
    }

    public static void add(String id) {
        list.add(id);
    }

    public static ChannelHandlerContext get(String key) {
        return treeMap.get(key);
    }

    public static int treeReport() {
        logger.debug("连接服务的客户端数为[{}]-----------------------------", treeMap.size());
        return treeMap.size();
    }
}




