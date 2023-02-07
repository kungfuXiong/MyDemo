package com.qinglan.designPattern._12_observerPattern.weather;

import com.qinglan.designPattern._12_observerPattern.utils.WeatherUtil;
import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class ForecastHourWather extends WeatherSubscriber {
    String address = "";

    public void setWeather(String address) {
        try {
            DingdingUtil.sendTextMsg(WeatherUtil.returnHourWeather(address), new ArrayList<String>(), new ArrayList<String>(), true);
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

    public ForecastHourWather(String address) {
        super(address);
        this.address = address;
    }
}
