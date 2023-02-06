package com.qinglan.designPattern._12_observerPattern.shceduler.immediate;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeatherJob extends QuartzJobBean {
    @Autowired
    WeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        weatherService.sendWeather();
    }
}
