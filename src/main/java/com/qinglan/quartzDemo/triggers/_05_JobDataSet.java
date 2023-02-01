package com.qinglan.quartzDemo.triggers;


import com.qinglan.quartzDemo.jobs.HellloJobDataSet;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * SimpleTriggerImpl (org.quartz.impl.triggers)
 * CronTriggerImpl (org.quartz.impl.triggers)
 * CalendarIntervalTriggerImpl (org.quartz.impl.triggers)
 * DailyTimeIntervalTriggerImpl (org.quartz.impl.triggers)
 */
public class _05_JobDataSet {
    public static void main(String[] args) {

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(HellloJobDataSet.class)
                    .usingJobData("param","距离除夕还有：")
                    .withIdentity("cronJob", "xiongbl")
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "xiongbl")
                    .usingJobData("param","距离下班还有：")
                    .startNow()//一旦触发就开始执行
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
