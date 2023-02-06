package com.qinglan.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DingdingUtil {
    /**
     * 获取请求url
     *
     * @return 钉钉机器人地址
     */
    private static String getDingUrl() throws Exception {
        Long timestamp = System.currentTimeMillis();
        String secret = "SEC958b5333fd7a77c8c201974bd8dcdca07c3c7a875790beef8c2e2c78d883a16e";

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=5c19b30e351c7c5335541bcbd026659f28058314d6cba632390a27a52ee6d77f" + "&timestamp=" + timestamp + "&sign=" + sign;
        return dingUrl;
    }

    /**
     * 群里面发送消息
     *
     * @param content    消息内容
     * @param isAtAll    是否@所有人
     * @param mobileList 被@人的手机号
     * @param userIdList 被@人的用户userid
     * @throws Exception
     */
    public static void sendTextMsg(String content, List<String> mobileList, List<String> userIdList, boolean isAtAll) throws Exception {
        String dingUrl = getDingUrl();
        // 组装请求内容
        String reqStr = buildReqTextStr(content, isAtAll, mobileList, userIdList);
        // 推送消息（http请求）
        String result = HttpClientUtil.doPostJson(dingUrl, reqStr);
        System.out.println("钉钉请求发送成功，返回结果：" + result);
    }

    /**
     * 组装请求报文-text类型
     *
     * @param content    消息内容
     * @param isAtAll    是否@所有人
     * @param mobileList 被@人的手机号
     * @param atUserIds  被@人的用户userid
     * @return
     */
    public static String buildReqTextStr(String content, boolean isAtAll, List<String> mobileList, List<String> atUserIds) {
        Map<String, String> contentMap = new HashMap<>();
        contentMap.put("content", content);

        Map<String, Object> atMap = new HashMap<>();
        atMap.put("isAtAll", isAtAll);
        atMap.put("atMobiles", mobileList);
        atMap.put("atUserIds", atUserIds);

        Map<String, Object> reqMap = new HashMap<>();
        reqMap.put("msgtype", "text");
        reqMap.put("text", contentMap);
        reqMap.put("at", atMap);

        return JSONObject.toJSONString(reqMap);
    }
}
