package com.abw.blog.interceptor;

import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.exception.AbwException;
import com.abw.blog.common.constants.RspCodeEnum;
import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fanghuabao on 2018/4/23 0023.
 * 暂时不用
 */
public class InterceptorConfig implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("afterCompletion");
        BaseRsp baseRsp = null;
        if(e instanceof AbwException){
            AbwException abwException = (AbwException)e;
            baseRsp = new BaseRsp(abwException.getCode(),abwException.getMsg());
        }else{
            baseRsp = new BaseRsp(RspCodeEnum.FAIL.getRspCode(),RspCodeEnum.FAIL.getRspMsg(e.getMessage()));
        }

        httpServletResponse.getWriter().write(JSON.toJSONString(baseRsp));
    }
}
