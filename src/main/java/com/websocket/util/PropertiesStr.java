package com.websocket.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 12:56
 */
public class PropertiesStr {

    private Logger logger = LoggerFactory.getLogger(PropertiesStr.class);

    public static int inBound;

    //redis链接
    public static HashMap<String, Integer> redisclustor = new HashMap<String, Integer>();
    //listener链接
    public static HashMap<String, Integer> listenerclustor = new HashMap<String, Integer>();

    public static int maxTotal = 5000;//最大分配的对象数
    public static int maxIdle = 1000;//控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8
    public static int maxWaitMillis = 10001;//等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    public static int redisTimeout = 1000;

    public static String wsUrl = "";

    public void initProperties() throws IOException {
        Properties prop = new Properties();
//        InputStream in = this.getClass().getResourceAsStream("/server_official.properties");
        InputStream in = this.getClass().getResourceAsStream("/server_test.properties");

        prop.load(in);
        PropertiesStr.inBound = Integer.parseInt(prop.getProperty("InBound"));

        String[] redishostsandports = prop.getProperty("redishost").split(",");
        logger.debug("redishostsandports[{}]", redishostsandports.length);
        for (int i = 0; i < redishostsandports.length; i++) {
            String[] onehostport = redishostsandports[i].split(":");
            redisclustor.put(redishostsandports[i], Integer.parseInt(onehostport[1]));
        }
        //listenerhost
        String[] listenerhosts = prop.getProperty("listenerhost").split(",");
        logger.debug("listenerhosts{}", listenerhosts.length);
        for (int i = 0; i < listenerhosts.length; i++) {
            String[] onelistenerhostport = listenerhosts[i].split(":");
            listenerclustor.put(listenerhosts[i], Integer.parseInt(onelistenerhostport[1]));
        }
        PropertiesStr.maxTotal = Integer.parseInt(prop.getProperty("maxTotal"));
        PropertiesStr.maxIdle = Integer.parseInt(prop.getProperty("maxIdle"));
        PropertiesStr.maxWaitMillis = Integer.parseInt(prop.getProperty("maxWaitMillis"));
        PropertiesStr.redisTimeout = Integer.parseInt(prop.getProperty("redisTimeout"));

        PropertiesStr.wsUrl = prop.getProperty("wsUrl");

    }
}
