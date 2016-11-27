package com.websocket.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.websocket.bean.protocolbean.Result;
import com.websocket.service.IMessagePushService;
import com.websocket.service.MessagePushService;
import com.websocket.util.CommonConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LeoAshin on 2016/11/9.
 * websocket_http in 18:19
 */
public class OperateMsgC {

    private Logger logger = LoggerFactory.getLogger(OperateMsgC.class);

    private IMessagePushService pushService = new MessagePushService();

    /**
     * 给运营端推送消息
     *
     * @param body
     * @param result
     * @return
     */
    public Result operateMsgPush(String body, Result result) {

        try {
            JSONObject object = JSON.parseObject(body);

            String res = pushService.pushMsg(body, null);
            if (res.equals(CommonConst.ERROR)) {
                result.setCode(res);
                result.setStatus(CommonConst.ONE_SHORT);
            } else {
                result.setStatus(CommonConst.ZERO_SHORT);
            }

        } catch (Exception e) {
            logger.error("OperateMsgC.operateMsgPush error", e);
            result.setStatus(CommonConst.ONE_SHORT);
            result.setCode(CommonConst.ERROR);
        }

        return result;
    }

    public Result pushLastestMsgStatus(String body, Result result) {
        return result;
    }

    /**
     * 给商家端推送消息
     *
     * @param body
     * @return
     */
    public Result buisnessMsgPush(String body, Result result) {
        return null;
    }
}
