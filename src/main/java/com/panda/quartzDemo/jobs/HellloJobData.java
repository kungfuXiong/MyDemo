package com.panda.quartzDemo.jobs;

import com.panda.quartzDemo.utils.DFUtil;
import org.quartz.*;
import sun.util.calendar.BaseCalendar;


import java.text.ParseException;
import java.util.Date;
import java.util.StringJoiner;


public class HellloJobData implements Job {
    public static  final String SPRING_FESTIVAL = "2023-01-21 00:00:00";
    public static  final String XIA_BAN = "2023-01-17 17:30:00";
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Trigger trigger = jobExecutionContext.getTrigger();
        JobDetail jobDetail = jobExecutionContext.getJobDetail();

        StringJoiner stringJoiner = null;
        try {
            stringJoiner = new StringJoiner(" ")
//                    .add("HelloJob.execute")
                    .add(DFUtil.format(new Date()))
//                    .add(Thread.currentThread().getName())
//                    .add(jobExecutionContext.getTrigger().getKey().getName())
//                    .add(jobExecutionContext.getTrigger().getKey().getGroup())
                    .add(jobDetail.getJobDataMap().getString("param")+ (DFUtil.sdf.parse(SPRING_FESTIVAL).getTime()-System.currentTimeMillis())/1000L+"s")
                    .add(trigger.getJobDataMap().getString("param1")+ (DFUtil.sdf.parse(XIA_BAN).getTime()-System.currentTimeMillis())/1000L+"s");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringJoiner);
    }


}
