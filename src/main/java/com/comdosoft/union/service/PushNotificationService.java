package com.comdosoft.union.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushTagMessageRequest;
import com.baidu.yun.channel.model.PushTagMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;

/**
 * 推送通知
 * 
 * @author zengguang
 * 
 */
@Service
public class PushNotificationService {

    /**
     * 日志记录器
     */
    private static final Log logger = LogFactory.getLog(PushNotificationService.class);

    /**
     * 应用标识
     */
    @Value("${push.apiKey}")
    private String apiKey;

    /**
     * 应用私钥
     */
    @Value("${push.secretKey}")
    private String secretKey;

    /**
     * 1:Developer 2:Production
     */
    @Value("${push.deployStatus}")
    private int deployStatus;

    /**
     * 消息类型 <br>
     * 0：消息（透传给应用的消息体） <br>
     * 1：通知（对应设备上的消息通知） <br>
     * 默认值为0
     */
    private static final int messageType = 1;

    /**
     * 推送 (异步)<br>
     * <分组广播>
     * 
     * @param deviceType
     * @param tagName
     * @param jsonMessage
     */
    public void pushTagMessageAsynchronous(final int deviceType, final String tagName, final String jsonMessage) {
        new Thread(new Runnable() {
            public void run() {
                pushTagMessage(deviceType, tagName, jsonMessage);
            }
        }).start();
    }

    /**
     * 推送<br>
     * <分组广播,由Android or IOS Push SDK拦截并解析>
     * 
     * @param deviceType
     * @param tagName
     * @param message
     */
    public void pushTagMessage(int deviceType, String tagName, String jsonMessage) {

        logger.debug("推送通知请求deviceType=" + deviceType);
        logger.debug("推送通知请求tagName=" + tagName);
        logger.debug("推送通知请求报文=" + jsonMessage);

        // 1. 设置developer平台的ApiKey/SecretKey
        ChannelKeyPair pair = new ChannelKeyPair(apiKey, secretKey);

        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);

        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            @Override
            public void onHandle(YunLogEvent event) {
                logger.debug(event.getMessage());
            }
        });

        try {

            // 4. 创建请求对象
            PushTagMessageRequest requestIOS = new PushTagMessageRequest();
            requestIOS.setMessageType(messageType);
            requestIOS.setTagName(tagName);
            requestIOS.setDeviceType(4); // 1:web 2:pc 3:android 4:ios 5:wp
            requestIOS.setDeployStatus(deployStatus); // 1: Developer 2: Production
            requestIOS.setMessage(jsonMessage);

            PushTagMessageRequest requestAndroid = new PushTagMessageRequest();
            requestAndroid.setMessageType(messageType);
            requestAndroid.setTagName(tagName);
            requestAndroid.setDeviceType(3); // 1:web 2:pc 3:android 4:ios 5:wp
            requestAndroid.setMessage(jsonMessage);

            // 5. 调用接口
            PushTagMessageResponse responseAndroid = channelClient.pushTagMessage(requestAndroid);
            PushTagMessageResponse responseIOS = channelClient.pushTagMessage(requestIOS);

            // 6. 认证推送成功
            logger.debug("push android amount : " + responseAndroid.getSuccessAmount());
            logger.debug("push ios amount : " + responseIOS.getSuccessAmount());

        } catch (ChannelClientException e) { // 处理客户端错误异常
            logger.error(e);
        } catch (ChannelServerException e) {// 处理服务端错误异常
            logger.error(e);
            logger.warn(String.format("request_id: %d, error_code: %d, error_message: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
    }
}