package com.abw.blog.common.interceptor;

/**
 * Created by xujiankang on 2017/9/19.
 */

import com.abw.blog.common.BaseRsp;
import com.abw.blog.common.constants.RspCodeEnum;
import com.abw.blog.common.exception.AbwException;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

//@Component
public class ServiceInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ServiceInterceptor.class);

    /*@Pointcut("execution(public  * com.zb.payment.gan.paycore.service.impl.TradeServiceImpl.*(..))"
    		+ "||execution(public  * com.zb.payment.gan.yst.paycore.service.impl.YSTTradeServiceImpl.*(..))")*/
    //@Pointcut("execution(public  * com.abw.blog.controller.LoginController.*(..))")
    public void aspectjMethod() {
    }

    /**
     * Around 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     *
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp
     * @return
     * @throws Throwable
     */

    @Around(value = "aspectjMethod()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            Object[] args = pjp.getArgs();
            //打印请求参数
            printReqParams(pjp);
            /*for (Object object : args) {
                CommonValidation.valid(object);
            }*/
            result = pjp.proceed();
        } catch (AbwException e) {
            logger.error("操作异常:{}", e.getMessage());
            result = new BaseRsp(e.getCode(), e.getMsg());
        } catch (Exception e) {
            logger.error("系统异常:{}", e);
            result = BaseRsp.returnRsp(RspCodeEnum.FAIL.getRspCode(),RspCodeEnum.FAIL.getRspMsg(e.getMessage()));
        }
        long end = System.currentTimeMillis();
        logger.info("方法  {}, 执行结果  {} 耗时:{}ms", getShortMethodName(pjp), JSONObject.toJSONString(result),(end-start));
        return result;
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
     *
     * 注意：执行顺序在Around Advice之后
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "aspectjMethod()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
        MethodInvocationProceedingJoinPoint methodpoint = (MethodInvocationProceedingJoinPoint) joinPoint;
        logger.info("错误异常, 方法 {}, {} ", methodpoint.getSignature().toShortString(), ex.getMessage());
    }

    private void printReqParams(ProceedingJoinPoint pjp){

        Object[] args = pjp.getArgs();

        StringBuilder sb = new StringBuilder();

        sb.append("方法  {}, 入参【");

        String[]  jsonArgs = new String[args.length+1];

        String methodName=pjp.getSignature().toString();

        jsonArgs[0]=getShortMethodName(pjp);

        for(int i=0;i<args.length;i++){

            sb.append(args[i].getClass().getSimpleName()+"={},");

            jsonArgs[i+1]= JSONObject.toJSONString(args[i]);

        }

        if(sb.toString().endsWith(",")){

            sb.delete(sb.length()-1, sb.length());

        }

        sb.append("】");

        logger.info(sb.toString(),jsonArgs);

    }

    /**
     *
     * getShortMethodName:获取简短方法名. <br/>
     *PayRsp com.zb.payment.gan.facade.service.TestService.test(PayReq)==>> TestService.test(PayReq)
     * @return
     */
    private String getShortMethodName(ProceedingJoinPoint pjp){

        String longMethodName=pjp.getSignature().toString();

        String[] names=longMethodName.split("\\.");

        return names[names.length-2]+"."+names[names.length-1];
    }

}