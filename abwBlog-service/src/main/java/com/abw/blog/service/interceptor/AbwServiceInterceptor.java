package com.abw.blog.service.interceptor;

import com.abw.blog.common.interceptor.ServiceInterceptor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 */
@Aspect
@Component
public class AbwServiceInterceptor extends ServiceInterceptor{
    @Pointcut("execution(public  * com.abw.blog.service.impl.*ServiceImpl.*(..))")
    public void aspectjMethod() {

    }

}
