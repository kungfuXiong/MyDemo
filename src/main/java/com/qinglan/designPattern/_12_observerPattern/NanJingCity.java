package com.qinglan.designPattern._12_observerPattern;

import com.qinglan.utils.DingdingUtil;

import java.util.ArrayList;

public class NanJingCity extends WeatherSubscriber{
    String address = "";


    void setWeather(String address) {
        ArrayList<String> mobile = new ArrayList<>();
        mobile.add("18651883652");
        mobile.add("18651881013");
        mobile.add("18651881259");
        mobile.add("18651882100");
        try {
            DingdingUtil.sendTextMsg(getWeather(address), mobile,new ArrayList<String>(),true);
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

    public NanJingCity(String address) {
        super(address);
        this.address = address;
    }
}
