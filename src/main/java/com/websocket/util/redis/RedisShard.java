package com.websocket.util.redis;

import com.websocket.util.PropertiesStr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.websocket.util.PropertiesStr.listenerclustor;
import static com.websocket.util.PropertiesStr.redisclustor;


/**
 * Created by andilyliao on 16-4-2.
 */
//redis分布式集群以及单机集群
//shardedredispool分布式的
//redispools单机的
public class RedisShard {

    private static Logger logger = LoggerFactory.getLogger(RedisShard.class);
    private static ShardedJedisPool shardedredispool = null;
    private static Map<Integer, JedisPool> redispools = null;

    public static JedisPoolConfig jedisPoolConfig() {//Jedis池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(PropertiesStr.maxTotal);//最大活动的对象个数
        jedisPoolConfig.setMaxIdle(PropertiesStr.maxIdle);//对象最大空闲时间
        jedisPoolConfig.setMaxWaitMillis(PropertiesStr.maxWaitMillis);//获取对象时最大等待时间
        jedisPoolConfig.setTestOnBorrow(false);//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        return jedisPoolConfig;
    }

    //分布式
    public static void initRedisShard() {

        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        logger.debug("shard redis are:------------------------------{");
        for (String hostandport : redisclustor.keySet()) {
            logger.debug(hostandport);
            String[] onehostport = hostandport.split(":");
            JedisShardInfo si = new JedisShardInfo(onehostport[0], redisclustor.get(hostandport), hostandport);
            shards.add(si);
        }
        logger.debug("}------------------------------");
        shardedredispool = new ShardedJedisPool(jedisPoolConfig(), shards);
    }

    public static void distoryRedisShard() {
        shardedredispool.destroy();
    }

    public static ShardedJedis getJedisObject() {
        return shardedredispool.getResource();
    }

    public static void returnJedisObject(ShardedJedis jedis) {
        shardedredispool.returnResourceObject(jedis);
    }//返还到连接池

    //单机
    public static void initJedisPool() {
        redispools = new HashMap<Integer, JedisPool>();
        int hashmod = 0;
        logger.debug("one redis are:------------------------------{");
        for (String hostandport : listenerclustor.keySet()) {
            logger.debug(hostandport);
            String[] onehostport = hostandport.split(":");
            redispools.put(hashmod, new JedisPool(jedisPoolConfig(), onehostport[0], listenerclustor.get(hostandport)));
            hashmod++;
        }
        logger.debug("}------------------------------");
    }

    public static void distoryRedisPools() {
        for (Integer i : redispools.keySet()) {
            redispools.get(i).destroy();
        }
    }

    public static Jedis getJedis(int hashmod) {
        return redispools.get(hashmod).getResource();
    }

    public static Jedis getJedis(JedisPool jedispool) {
        return jedispool.getResource();
    }

    public static Map<Integer, JedisPool> getAllJedisPool() {
        return redispools;
    }

    public static JedisPool getJedisPool(int hashmod) {
        return redispools.get(hashmod);
    }

    public static void returnJedisObject(Jedis jedis, int hashmod) {
        redispools.get(hashmod).returnResourceObject(jedis);
    }

    public static void returnJedisObject(Jedis jedis, JedisPool jedispool) {
        jedispool.returnResourceObject(jedis);
    }
}
