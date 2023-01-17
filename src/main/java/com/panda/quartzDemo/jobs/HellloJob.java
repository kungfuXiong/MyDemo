package com.panda.quartzDemo.jobs;

import com.panda.quartzDemo.utils.DFUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.StringJoiner;

public class HellloJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StringJoiner stringJoiner = new StringJoiner(" ")
                .add("HelloJob.execute")
                .add(DFUtil.format(new Date()))
                .add(Thread.currentThread().getName())
                .add(jobExecutionContext.getTrigger().getKey().getName())
                .add(jobExecutionContext.getTrigger().getKey().getGroup());

        System.out.println(stringJoiner);

    }
}
