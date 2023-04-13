package com.xbl.designPattern._12_observerPattern.weather;

import java.util.ArrayList;

public class WeatherPush {
    private ArrayList<WeatherSubscriber>  weatherSubscribers = new ArrayList<WeatherSubscriber>();

    public void attach(WeatherSubscriber weatherSubscriber){
        weatherSubscribers.add(weatherSubscriber);
    }

    public void attachAll(ArrayList<WeatherSubscriber>  weatherSubscriber){
        weatherSubscriber.addAll(weatherSubscribers);
    }

    public void notifyAllSubscribers(){
        for (WeatherSubscriber weatherSubscriber : weatherSubscribers) {
            weatherSubscriber.setWeather(weatherSubscriber.getAddress());
        }
    }
}
