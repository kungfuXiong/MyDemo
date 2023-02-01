package com.qinglan.quartzDemo.triggers;

import com.qinglan.quartzDemo.jobs.HellloJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class _01_quickStart {
    public static void main(String[] args) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

            defaultScheduler.start();

            JobDetail jobDetail = newJob(HellloJob.class)
                    .withIdentity("firstJob", "xiongbl")
                    .build();


            SimpleTrigger simpleTrigger = newTrigger()
                    .withIdentity("firstTrigger", "xiongbl")
                    .startNow()
                    .withSchedule(
                            simpleSchedule()
                                    .withIntervalInSeconds(4)
                                    .repeatForever()
                    )
                    .build();

            SimpleTrigger simpleTrigger1 = newTrigger()
                    .withIdentity("secondTrigger", "xiongbl")
                    .forJob("firstJob", "xiongbl")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever()
                    ).build();

            defaultScheduler.scheduleJob(jobDetail, simpleTrigger);
            defaultScheduler.scheduleJob(simpleTrigger1);

            TimeUnit.SECONDS.sleep(12);

            defaultScheduler.pauseAll();

            defaultScheduler.shutdown();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
