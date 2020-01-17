//package com.luziye.bootluanch.timerTask;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzSimpleConfig {
//    @Bean
//    public JobDetail uploadTaskDetail(){
//        return JobBuilder.newJob(QuartzSimpleTask.class)
//                .withIdentity("QuartzSimpleTask")
//                .storeDurably()
//                .build();
//    }
//    @Bean
//    public Trigger uploadTaskTrigger(){
//        CronScheduleBuilder cronScheduleBuilder=CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
//        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
//                .withIdentity("QuartzSimpleTask")
//                .withSchedule(cronScheduleBuilder)
//                .build();
//    }
//}
