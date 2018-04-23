package com.abw.blog.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 * 暂时不用
 */
public class WebAppConfig extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new InterceptorConfig());

    }

}
