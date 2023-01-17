package com.panda.quartzDemo.triggers;


import com.panda.quartzDemo.jobs.HellloJob;
import com.panda.quartzDemo.jobs.HellloJobData;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * SimpleTriggerImpl (org.quartz.impl.triggers)
 * CronTriggerImpl (org.quartz.impl.triggers)
 * CalendarIntervalTriggerImpl (org.quartz.impl.triggers)
 * DailyTimeIntervalTriggerImpl (org.quartz.impl.triggers)
 */
public class _04_JobDataDemo {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(HellloJobData.class)
                    .usingJobData("param","距离除夕还有：")
                    .withIdentity("cronJob", "xiongbl")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "xiongbl")
                    .usingJobData("param1","距离下班还有：")
                    .startNow()
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule("* * * * * ? *")
                    ).build();

            scheduler.scheduleJob(job,trigger);

//            TimeUnit.MINUTES.sleep(2);

//            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
