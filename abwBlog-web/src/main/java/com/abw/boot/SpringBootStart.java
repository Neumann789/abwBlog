package com.abw.boot;

import com.abw.blog.interceptor.WebAppConfig;
import com.abw.blog.mapper.AbwUserMapper;
import com.abw.blog.model.AbwUser;
import com.abw.blog.service.interceptor.AbwServiceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fanghuabao on 2018/4/13 0013.
 */

@SpringBootApplication
@ComponentScan( basePackages = "com.abw.blog.*")
@MapperScan("com.abw.blog.mapper")
public class SpringBootStart {


    private static final Logger logger = LoggerFactory.getLogger(SpringBootStart.class);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext acc = new SpringApplicationBuilder().sources(SpringBootStart.class).web(true).bannerMode(Banner.Mode.LOG).run(args);
        //SpringApplication.run(SpringBootStart.class,args);
        //AbwUserMapper abwUserMapper = acc.getBean(AbwUserMapper.class);
       // AbwUser abwUser = abwUserMapper.selectByPrimaryKey(1L);
        //AbwServiceInterceptor abwServiceInterceptor = acc.getBean(AbwServiceInterceptor.class);
        long end = System.currentTimeMillis();
        logger.info("abwBlog start success ,cost:{} ms", end - start);
        new CountDownLatch(1).await();
    }

    @Bean
    public WebFilter WebFilter(){

        return new WebFilter();

    }

    /**
     * contoller层拦截器 但是发现此处的拦截用起来不是很方便
     * @return
     */
/*    @Bean
    public WebAppConfig WebAppConfig(){
        return new WebAppConfig();
    }*/

}
