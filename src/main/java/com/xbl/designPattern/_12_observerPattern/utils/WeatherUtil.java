package com.xbl.designPattern._12_observerPattern.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xbl.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

/**
 * 天气获取工具类
 *
 * @author 青岚
 * @date 2023年2月7日 14点59分
 */
public class WeatherUtil {

    @Value("${weather.key}")
    static String key = "a6408cf554a14f3286d4fa3748eb8ce1";

    @Value("${weather.url24h}")
    static String url24h = "https://devapi.qweather.com/v7/weather/24h";

    @Value("${weather.url3d}")
    static String url3d = "https://devapi.qweather.com/v7/weather/3d";

    @Value("${weather.urlNow}")
    static String urlNow = "https://devapi.qweather.com/v7/weather/now";

    static final String JIAN_YE = "101190110";

    static final String PU_KOU = "101190107";

    static final String DONG_TAI = "101190707";

    static final String SHU_SHAN = "101220109";


    /**
     * 返回未来几小时的天气
     *
     * @param city
     * @return weather
     */
    public static String returnHourWeather(String city) {
        String weather = "未来3小时内无雨，放心出门";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("location", city);
        map.put("key", key);
        String s = doGet(url24h, map);
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray daily = jsonObject.getJSONArray("hourly");
        for (int i = 0; i < 3; i++) {
            if (daily.getJSONObject(i).getString("text").contains("雨")) {
                weather = "未来3小时内有雨，出门记得带伞";
            }
        }
        return weather;
    }

    /**
     * 返回未来3天的天气
     *
     * @param city
     * @return weather
     */
    public static String returnDayWeather(String city) {
        String weather = "";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("location", city);
        map.put("key", key);
        String s = doGet(url3d, map);
        JSONObject jsonObject = JSONObject.parseObject(s);
        JSONArray daily = jsonObject.getJSONArray("daily");
        for (int i = 0; i < 3; i++) {
            weather = weather + JsonParseUtil.parseMarkDown(daily.getJSONObject(i));
        }
        return weather;
    }

    /**
     * 返回实时天气
     *
     * @param city
     * @return weather
     */
    public static String returnImmedWeather(String city) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("city", city);
        map.put("key", key);
        String s = doGet(urlNow, map);
        JSONObject weather = JSONObject.parseObject(s).getJSONObject("now");
        return weather.getString("city") + "\n" + "当前天气:" + weather.getString("text") + "\n" + "当前温度:" + weather.getString("temp");
    }

    static String doGet(String url, HashMap<String, String> map) {
        return HttpClientUtil.doGet(url, map);
    }
}
