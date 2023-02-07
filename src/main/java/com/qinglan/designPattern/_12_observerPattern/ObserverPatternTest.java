package com.qinglan.designPattern._12_observerPattern;

import com.qinglan.designPattern._12_observerPattern.utils.WeatherUtil;
import com.qinglan.designPattern._12_observerPattern.weather.ForecastWeather;
import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class ObserverPatternTest {
    public static void main(String[] args) throws Exception {

        ArrayList<String> mobiles = new ArrayList<>();
        mobiles.add("18651881861");

        ArrayList<String> users = new ArrayList<>();
//        users.add("18651881861");
//        DingdingUtil.sendMarkdownMsg("请查收建邺区最近天气:",WeatherUtil.returnDayWeather("101060101",0),true,mobiles,users);
//        DingdingUtil.sendMarkdownMsg("请查收建邺区最近天气:",WeatherUtil.returnDayWeather("101060101",1),true,mobiles,users);
//        DingdingUtil.sendMarkdownMsg("请查收建邺区最近天气:",WeatherUtil.returnDayWeather("101060101",2),true,mobiles,users);

        ForecastWeather forecastWeather = new ForecastWeather("101190110");
        forecastWeather.setWeather(forecastWeather.getAddress());
//        DingdingUtil.sendTextMsg(WeatherUtil.returnDayWeather("101190110"),mobiles,users,false);

//        DingdingUtil.sendTextMsg(WeatherUtil.returnHourWeather("101190110"), new ArrayList<String>(), new ArrayList<String>(), true);

    }
}
