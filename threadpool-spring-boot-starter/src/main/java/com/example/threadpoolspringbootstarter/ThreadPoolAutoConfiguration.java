package com.example.threadpoolspringbootstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author Jusven
 * @Date 2024/3/7 15:10
 */
@Configuration
public class ThreadPoolAutoConfiguration {

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class)
    public ThreadPoolExecutor newThreadPoolExecutor() {
        return new ThreadPoolExecutor(10,20,3000, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
    }
}
