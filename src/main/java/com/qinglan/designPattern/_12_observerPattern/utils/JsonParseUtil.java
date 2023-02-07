package com.qinglan.designPattern._12_observerPattern.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonParseUtil {
    public static String parse(JSONObject jsonObject) {
        String weather ="";
        String enter = "  \n  ";
        weather =
                "----------------------------------"+enter+
                "**日期**  "+jsonObject.getString("fxDate")+enter+
                "**白天天气**  "+jsonObject.getString("textDay")+"   "+
                "**夜晚天气**  "+jsonObject.getString("textNight")+enter+
                "**最高温**  "+jsonObject.getString("tempMax")+"°C"+"   "+
                "**最低温**  "+jsonObject.getString("tempMin")+"°C"+enter+
                "**风向**  "+jsonObject.getString("windDirDay")+"   "+
                "**风力**  "+jsonObject.getString("windScaleDay")+"级"+enter
                ;

        if (weather.contains("雨")){
            weather = weather + "***今日有雨，出门请注意带伞哦！***"+enter;
        } else if (weather.contains("雪")) {
            weather = weather + "***今日有雪，出门请注意保暖防滑哦！***"+enter;
        }else if (weather.contains("舞")) {
            weather = weather + "***今日有雾，开车请注意保持安全距离哦！***"+enter;
        }else if (jsonObject.getInteger("tempMax")<5||jsonObject.getInteger("tempMin")<0) {
            weather = weather + "***今日气温较低，出门请注意保暖！***"+enter;
        }
        return weather;
    }
}
