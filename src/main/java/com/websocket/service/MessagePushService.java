package com.websocket.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.websocket.bean.Message;
import com.websocket.bean.protocolbean.Result;
import com.websocket.util.ChannelManager;
import com.websocket.util.CommonConst;
import com.websocket.util.MessageSender;
import com.websocket.util.redis.RedisShard;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;

import java.util.List;
import java.util.Map;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 18:50
 */
public class MessagePushService implements IMessagePushService {

    private Logger logger = LoggerFactory.getLogger(MessagePushService.class);

    @Override
    public String pushMsg(String context, String uId) {
        logger.info("MessagePushService.pushMsg context[{}], uId[{}]", context, uId);

        ShardedJedis shardedJedis = RedisShard.getJedisObject();

        try {
            List<String> listKey = shardedJedis.lrange(CommonConst.CHANNELS + CommonConst.SPLITOR + uId, CommonConst.ZERO_LONG, CommonConst.NEGATIVE_ONE_LONG);

            Message message = new Message();
            message.setHead(CommonConst.ALERT);
            message.setBody(context);
//
            for (String key : listKey) {

                ChannelHandlerContext ctx = ChannelManager.get(key);
                if (ctx != null) {

                    MessageSender.pushMsg(ctx, JSON.toJSONString(message));
                }
            }
            MessageSender.pushMsgToAll(context);
            return CommonConst.ZERO;
        } catch (Exception e) {
            return CommonConst.ERROR;
        } finally {
            RedisShard.returnJedisObject(shardedJedis);
        }
    }

    @Override
    public String checkUnreadMsg(ChannelHandlerContext ctx) {
        logger.info("MessagePushService.checkUnreadMsg in-----");

        ShardedJedis shardedJedis = RedisShard.getJedisObject();
        Map<String, Long> map = Maps.newHashMap();
        try {
            //用户举报
            String userStatKey = CommonConst.MSG + CommonConst.SPLITOR + CommonConst.REPORT + CommonConst.SPLITOR + CommonConst.USER + CommonConst.SPLITOR + CommonConst.UNREAD;
            Long userStat = shardedJedis.scard(userStatKey);
            //商家举报
            String resStatKey = CommonConst.MSG + CommonConst.SPLITOR + CommonConst.REPORT + CommonConst.SPLITOR + CommonConst.RES + CommonConst.SPLITOR + CommonConst.UNREAD;
            Long resStat = shardedJedis.scard(resStatKey);
            //订单发起退款提醒
            String orderRefundKey = CommonConst.MSG + CommonConst.SPLITOR + CommonConst.REFUND + CommonConst.SPLITOR + CommonConst.ORDER + CommonConst.SPLITOR + CommonConst.UNREAD;
            Long orderRefund = shardedJedis.scard(orderRefundKey);
            //退款核销提醒
            String refundKey = CommonConst.MSG + CommonConst.SPLITOR + CommonConst.ALERT + CommonConst.SPLITOR + CommonConst.ORDER + CommonConst.SPLITOR + CommonConst.UNREAD;
            Long refundStat = shardedJedis.scard(refundKey);
            //商家菜品审核提醒
            String dishKey = CommonConst.MSG + CommonConst.SPLITOR + CommonConst.DISH + CommonConst.SPLITOR + CommonConst.ID + CommonConst.SPLITOR + CommonConst.UNREAD;
            Long dishStat = shardedJedis.scard(dishKey);
            //主播申请
            String anchorApplyKey = CommonConst.MSG + CommonConst.SPLITOR + CommonConst.APPLY + CommonConst.SPLITOR + CommonConst.ANCHOR + CommonConst.SPLITOR + CommonConst.UNREAD;
            Long anchorApplyStat = shardedJedis.scard(anchorApplyKey);

            map.put(CommonConst.TOTAL, userStat + resStat + refundStat + dishStat + anchorApplyStat + orderRefund);
            map.put(CommonConst.REFUND, orderRefund);
            map.put(CommonConst.ANCHORAPPLY, anchorApplyStat);
            map.put(CommonConst.DISHHANDLERALERT, dishStat);
            map.put(CommonConst.RESREPORT, resStat);
            map.put(CommonConst.USERREPORT, userStat);
            map.put(CommonConst.REFUNDALERT, refundStat);

            Message message = new Message();
            message.setBody(map);
            message.setHead(CommonConst.MESSAGE);

            MessageSender.pushMsg(ctx, JSON.toJSONString(message));
            return CommonConst.ZERO;
        } catch (Exception e) {
            logger.error("MessagePushService.checkUnreadMsg error", e);
            return CommonConst.ERROR;
        } finally {
            RedisShard.returnJedisObject(shardedJedis);
        }
    }


}
