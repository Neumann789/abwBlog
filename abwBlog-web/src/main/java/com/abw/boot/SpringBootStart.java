package com.abw.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fanghuabao on 2018/4/13 0013.
 */

@SpringBootApplication
@ComponentScan( basePackages = "com.abw.*")
public class SpringBootStart {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootStart.class);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        new SpringApplicationBuilder().sources(SpringBootStart.class).web(true).bannerMode(Banner.Mode.LOG).run(args);
        //SpringApplication.run(SpringBootStart.class,args);
        long end = System.currentTimeMillis();
        logger.info("abwBlog start success ,cost:{} ms", end - start);
        new CountDownLatch(1).await();
    }

}
