package com.qinglan.designPattern._12_observerPattern.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinglan.utils.HttpClientUtil;

import java.util.HashMap;

public class ForecastWeatherUtil {

    public static String returnWeather(String city) {
        String weather = "";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("location", city);//101190110
        map.put("key", "a6408cf554a14f3286d4fa3748eb8ce1");
        String s = HttpClientUtil.doGet("https://devapi.qweather.com/v7/weather/3d",map);
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray daily = jsonObject.getJSONArray("daily");
        for (int i = 0; i < 3; i++) {
            weather=weather+JsonParseUtil.parse(daily.getJSONObject(i));
        }
        return weather;
    }
}
