//package com.luziye.bootluanch.timerTask;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class ScheduledJobs {
//    //表示方法执行完成后5秒再开始执行
//    @Scheduled(fixedDelay = 5000)
//    public void fixedDelayJob()throws Exception{
//        System.out.println("fixedDelay 开始:" + new Date());
//        Thread.sleep(10 * 1000);
//        System.out.println("fixedDelay 结束:" + new Date());
//
//    }
//    //表示每隔3秒
//    @Scheduled(fixedRate = 3000)
//    public void fixedRateJob()throws Exception{
//        System.out.println("fixedRate 开始:" + new Date());
//        Thread.sleep(10 * 1000);
//        System.out.println("fixedRate 结束:" + new Date());
//
//    }
//    //表示每隔10秒执行一次
//    @Scheduled(cron="0/10 * * * * ? ")
//    public void cronJob(){
//        System.out.println("=========================== ...>>cron...." + new Date());
//    }
//}
