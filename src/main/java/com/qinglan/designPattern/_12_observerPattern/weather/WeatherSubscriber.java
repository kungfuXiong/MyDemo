package com.qinglan.designPattern._12_observerPattern.weather;

import com.qinglan.designPattern._12_observerPattern.utils.ImmediateWeatherUtil;

public abstract class WeatherSubscriber {
    String address = "";

    abstract void setWeather(String address);

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = "北京";
    }

    abstract String getWeather(String address);

    public WeatherSubscriber(String address) {
        this.address = address;
    }

    public WeatherSubscriber() {
    }
}
