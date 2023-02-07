package com.qinglan.designPattern._12_observerPattern.weather;

import com.qinglan.designPattern._12_observerPattern.utils.WeatherUtil;
import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class ForecastWeather extends WeatherSubscriber {
    String address = "";

    public void setWeather(String address) {
        try {
            DingdingUtil.sendMarkdownMsg("请查收建邺区今天天气:",WeatherUtil.returnDayWeather(address),true,new ArrayList<String>(),new ArrayList<String>());
        } catch (Exception e) {
            e.getMessage();
        }
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

    public ForecastWeather(String address) {
        super(address);
        this.address = address;
    }
}
