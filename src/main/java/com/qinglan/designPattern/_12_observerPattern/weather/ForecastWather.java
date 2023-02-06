package com.qinglan.designPattern._12_observerPattern.weather;

import com.qinglan.designPattern._12_observerPattern.utils.ForecastWeatherUtil;
import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class ForecastWather extends WeatherSubscriber {
    String address = "";

    void setWeather(String address) {
        try {
            DingdingUtil.sendTextMsg(getWeather(address),new ArrayList<String>(),new ArrayList<String>(),true);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    String getWeather(String address) {
        return ForecastWeatherUtil.returnWeather(address);
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
        this.address = address;
    }

    public ForecastWather(String address) {
        super(address);
        this.address = address;
    }
}
