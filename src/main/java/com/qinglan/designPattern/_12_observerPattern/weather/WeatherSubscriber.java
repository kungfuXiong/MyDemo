package com.qinglan.designPattern._12_observerPattern.weather;

public abstract class WeatherSubscriber {
    String address = "";

    public abstract void setWeather(String address);

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = "北京";
    }

    public WeatherSubscriber(String address) {
        this.address = address;
    }

    public WeatherSubscriber() {
    }

}
