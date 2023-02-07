package com.qinglan.designPattern._12_observerPattern;

import com.qinglan.designPattern._12_observerPattern.shceduler.forecast.ForecastWeatherService;
import com.qinglan.designPattern._12_observerPattern.utils.ForecastWeatherUtil;
import com.qinglan.designPattern._12_observerPattern.weather.ForecastWather;
import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class ObserverPatternTest {
    public static void main(String[] args) throws Exception {
//        WeatherPush weatherPush = new WeatherPush();
//
//        weatherPush.attach(new NanJingCity("320105"));
//        weatherPush.attach(new QingDaoCity("320111"));
//
//        weatherPush.notifyAllSubscribers();


//        DingdingUtil.sendMarkdownMsg("当前天气", ImmediateWeatherUtil.returnWeather("320105"),true,new ArrayList<String>(),new ArrayList<String>());
//        System.out.println(ForecastWeatherUtil.returnWeather("101190110"));
//        ForecastWeatherService forecastWeatherService = new ForecastWeatherService();
//        forecastWeatherService.sendWeather();
        DingdingUtil.sendMarkdownMsg("未来三日天气预报", ForecastWeatherUtil.returnWeather("101190110"),true,new ArrayList<String>(),new ArrayList<String>());
    }
}
