package com.qinglan.designPattern._12_observerPattern.utils;

import com.alibaba.fastjson.JSONObject;

public class JsonParseUtil {
    public static String parse(JSONObject jsonObject) {
        String enter = "\n";
        return
                "日期  "+jsonObject.getString("fxDate")+enter+
                "白天天气  "+jsonObject.getString("textDay")+enter+
                "夜晚天气  "+jsonObject.getString("textNight")+enter+
                "风向  "+jsonObject.getString("windDirDay")+enter+
                "风力  "+jsonObject.getString("windScaleDay")+"级"+enter+
                "最高温  "+jsonObject.getString("tempMax")+"°C"+enter+
                "最低温  "+jsonObject.getString("tempMin")+"°C"+enter;
    }
}
