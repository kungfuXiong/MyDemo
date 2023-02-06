package com.qinglan.designPattern._12_observerPattern.shceduler.immediate;



import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ImmediateWeatherTrigger {
    @Autowired
    Scheduler scheduler;

    @PostConstruct
    public void initJob(){
        JobDetail job = newJob(WeatherJob.class).build();

        Trigger trigger = newTrigger().startNow().withSchedule(

                //0 0 8,12,18 * * ?
                CronScheduleBuilder.cronSchedule("* * 10,12,14,16,18 * * ? *")
        )
        .build();

        try {
            scheduler.scheduleJob(job,trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}

