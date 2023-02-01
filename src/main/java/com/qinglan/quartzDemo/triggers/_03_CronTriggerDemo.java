package com.qinglan.quartzDemo.triggers;


import com.qinglan.quartzDemo.jobs.HellloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * SimpleTriggerImpl (org.quartz.impl.triggers)
 * CronTriggerImpl (org.quartz.impl.triggers)
 * CalendarIntervalTriggerImpl (org.quartz.impl.triggers)
 * DailyTimeIntervalTriggerImpl (org.quartz.impl.triggers)
 */
public class _03_CronTriggerDemo {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(HellloJob.class)
                    .withIdentity("cronJob", "xiongbl")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "xiongbl")
                    .startNow()
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule("1-10 * * * * ? *")
                    ).build();

            scheduler.scheduleJob(job,trigger);

            TimeUnit.MINUTES.sleep(2);

            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
