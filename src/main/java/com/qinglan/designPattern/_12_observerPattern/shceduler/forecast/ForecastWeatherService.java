package com.qinglan.designPattern._12_observerPattern.shceduler.forecast;

import com.qinglan.designPattern._12_observerPattern.weather.ForecastWather;
import com.qinglan.designPattern._12_observerPattern.weather.ImmediateWeather;
import com.qinglan.designPattern._12_observerPattern.weather.WeatherPush;
import org.springframework.stereotype.Service;

@Service
public class ForecastWeatherService {
    public void sendWeather(){
        WeatherPush weatherPush = new WeatherPush();
        weatherPush.attach(new ForecastWather("101190110"));
        weatherPush.notifyAllSubscribers();
    }

}
