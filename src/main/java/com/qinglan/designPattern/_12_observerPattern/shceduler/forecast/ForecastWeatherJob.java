package com.qinglan.designPattern._12_observerPattern.shceduler.forecast;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ForecastWeatherJob extends QuartzJobBean {
    @Autowired
    ForecastWeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        weatherService.sendWeather();
    }
}
