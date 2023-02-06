package com.qinglan.designPattern._12_observerPattern;

import com.qinglan.utils.DingdingUtil;
import com.qinglan.utils.HttpClientUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class ObserverPatternTest {
    public static void main(String[] args) throws Exception {
        WeatherPush weatherPush = new WeatherPush();

        weatherPush.attach(new NanJingCity("320105"));
        weatherPush.attach(new QingDaoCity("320111"));

        weatherPush.notifyAllSubscribers();

    }
}
