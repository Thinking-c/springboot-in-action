package com.thinking.springbootincation;

import com.thinking.springbootincation.project.task.ScheduleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/18
 */
@Component
public class ApplicationStartup implements CommandLineRunner {

    @Autowired
    private ScheduleTask scheduleTask;

    @Override
    public void run(String... args) throws Exception {

        //init application do something
//        scheduleTask.scheduleTaskForCron();

    }
}
