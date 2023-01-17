package com.panda.quartzDemo.jobs;

import com.panda.quartzDemo.utils.DFUtil;
import org.quartz.*;

import java.text.ParseException;
import java.util.Date;
import java.util.StringJoiner;


public class HellloJobDataSet implements Job {
//    public static final String SPRING_FESTIVAL = "2023-01-21 00:00:00";
//    public static final String XIA_BAN = "2023-01-17 17:30:00";
    /**
     * 常用参数可以通过set方式直接注入
     */
    public String param;

    public void setParam(String param) {
        this.param = param;
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        StringJoiner stringJoiner = null;

        stringJoiner = new StringJoiner(" ")
                .add("HelloJobDataSet.execute")
                .add(DFUtil.format(new Date()))
                .add(Thread.currentThread().getName())
                .add(jobExecutionContext.getTrigger().getKey().getName())
                .add(jobExecutionContext.getTrigger().getKey().getGroup())
                .add(param);
        System.out.println(stringJoiner);
    }


}
