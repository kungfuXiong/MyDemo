package com.panda.quartzDemo.jobs;

import com.panda.quartzDemo.service.HelloService;
import com.panda.quartzDemo.utils.DFUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.StringJoiner;

public class SpringJob extends QuartzJobBean {
    @Autowired
    HelloService helloService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {


        StringJoiner stringJoiner = null;

        stringJoiner = new StringJoiner(" ")
                .add("HelloJobDataSet.execute")
                .add(DFUtil.format(new Date()))
                .add(Thread.currentThread().getName())
                .add(helloService.test());
        System.out.println(stringJoiner);

    }
}
