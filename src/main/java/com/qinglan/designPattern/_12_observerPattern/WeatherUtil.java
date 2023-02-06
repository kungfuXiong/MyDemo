package com.qinglan.designPattern._12_observerPattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinglan.utils.HttpClientUtil;

import java.util.HashMap;

public class WeatherUtil {
    public static String returnWeather(String city) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("city", city);
        map.put("key", "4bc620cd0d7d4c0afa91dac297046958");
        map.put("extensions", "all");
        String s =HttpClientUtil.doGet("https://restapi.amap.com/v3/weather/weatherInfo", map);
        JSONArray jsonArray = JSONObject.parseObject(s).getJSONArray("lives");
        JSONObject weather = jsonArray.getJSONObject(0);
        return weather.getString("city")+"\n"+"当前天气:"+weather.getString("weather")+"\n"+"当前温度:"+weather.getString("temperature");
    }


}
