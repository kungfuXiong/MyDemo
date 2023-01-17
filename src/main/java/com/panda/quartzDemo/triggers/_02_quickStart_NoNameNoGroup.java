package com.panda.quartzDemo.triggers;

import com.panda.quartzDemo.jobs.HellloJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class _02_quickStart_NoNameNoGroup {
    public static void main(String[] args) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

            defaultScheduler.start();

            JobDetail jobDetail = newJob(HellloJob.class)
                    .build();


            Trigger simpleTrigger = newTrigger()
                    .startNow()
                    .withSchedule(
                            simpleSchedule()
                                    .withIntervalInSeconds(4)//调用间隔
//                                    .repeatForever()
                                    .withRepeatCount(5)//重复次数
                    )
                    .build();



            defaultScheduler.scheduleJob(jobDetail, simpleTrigger);

            TimeUnit.SECONDS.sleep(12);

            defaultScheduler.pauseAll();

            defaultScheduler.shutdown();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
