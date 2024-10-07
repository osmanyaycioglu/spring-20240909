package org.turkcell.trainint.spring.springweb.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class EventConf {

    @Bean
    public Executor myThreadPool(){
        return Executors.newFixedThreadPool(3);
    }

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster xyz(){
        SimpleApplicationEventMulticaster multicasterLoc = new SimpleApplicationEventMulticaster();
        multicasterLoc.setTaskExecutor(myThreadPool());
        return multicasterLoc;
    }


}
