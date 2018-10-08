package com.thinking.springbootincation.project.task;

import javafx.concurrent.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/18
 */
@Configuration
@Component
//@EnableScheduling
@Slf4j
public class ScheduleTask {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //初次执行任务之前需要等待的时间是initialDelay秒，然后每次间隔fixedDelay后执行（待任务执行完以后）
    @Scheduled(initialDelay = 10000, fixedDelay = 10000)
    public void scheduleTask(){
        log.info("[scheduleTask][initialDelay and fixedDelay]{}", sdf.format(new Date()));
    }

    //fixedRate:执行频率，每隔多少时间就启动任务，不管该任务是否启动完成
    @Scheduled(fixedRate = 10000)
    public void scheduleTask1(){
        log.info("[scheduleTask1][fixedRate]{}", sdf.format(new Date()));
    }

    //初次执行任务之前需要等待的时间是initialDelay秒，然后每次间隔fixedDelay后执行（待任务执行完以后）
    @Scheduled(initialDelayString = "${schedule.initialDelay}", fixedRateString = "${schedule.fixedDelay}")
    public void scheduleTaskForString(){
        log.info("[scheduleTaskForString][initialDelayString and fixedRateString]{}", sdf.format(new Date()));
    }

    @Scheduled(cron = "0 3 18 * * ?")
    public void scheduleTaskForCron(){
        log.info("[scheduleTaskForCron][cron]{}", sdf.format(new Date()));
    }


    public static void main(String[] args) {

       new ScheduleTask().test();

    }

    public void test(){
        Task task = new Task();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        ScheduledFuture<?> scheduledFuture = service.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);
//        scheduledFuture.cancel(true);
    }

    public class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("task");
        }
    }


}
