package com.luziye.bootluanch.timerTask;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class QuartzSimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz的定时任务执行时间："+new Date().toLocaleString());
    }
}
