package com.qinglan.designPattern._12_observerPattern;

import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class QingDaoCity extends WeatherSubscriber{
    String address = "";

    void setWeather(String address) {
        try {
            DingdingUtil.sendTextMsg(getWeather(address),new ArrayList<String>(),new ArrayList<String>(),true);
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

    public QingDaoCity(String address) {
        super(address);
        this.address = address;
    }
}
