package com.example.springhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
@EnableAsync

public class SpringHelloApplication implements WebMvcConfigurer {
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        configurer.setTaskExecutor(taskExecutor());
//        configurer.setDefaultTimeout(30_000);
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringHelloApplication.class, args);
    }
    @Bean(name = "Executor 1")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-1");
        executor.initialize();
        return executor;
    }
    @Bean(name = "Executor 2")
    public ThreadPoolTaskExecutor taskExecutor2() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-2");
        executor.initialize();
        return executor;
    }


}
