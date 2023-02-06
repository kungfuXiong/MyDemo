package com.qinglan.designPattern._12_observerPattern;

public abstract class WeatherSubscriber {
    String address = "北京";

    abstract void setWeather(String address);

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = "北京";
    }

    String getWeather(String address){
        return WeatherUtil.returnWeather(address);
    }

    public WeatherSubscriber(String address) {
        this.address = address;
    }

    public WeatherSubscriber() {
    }
}
