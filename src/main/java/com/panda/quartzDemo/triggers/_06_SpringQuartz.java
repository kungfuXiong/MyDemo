package com.panda.quartzDemo.triggers;


import com.panda.quartzDemo.jobs.SpringJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

//@Component
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class _06_SpringQuartz {
    @Autowired
    Scheduler scheduler;

    @PostConstruct
    public void initJob(){
        JobDetail job = newJob(SpringJob.class).build();

        Trigger trigger = newTrigger().startNow().withSchedule(

                CronScheduleBuilder.cronSchedule("* * * * * ? *")
        )
        .build();

        try {
            scheduler.scheduleJob(job,trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}

