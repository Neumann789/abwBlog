package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by fanghuabao on 2018/4/24 0024.
 */
public class FutureTaskTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start = System.currentTimeMillis();
        //System.out.println("程序开始:"+start);
        ExecutorService exec = Executors.newCachedThreadPool();

        List<ComputeTask> computeTaskList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            ComputeTask cpt = new ComputeTask("jack"+i);
            computeTaskList.add(cpt);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("执行线程池开始:"+t2);
        List<Future<Result>> futureList =  exec.invokeAll(computeTaskList);
        long t3 = System.currentTimeMillis();
        System.out.println("执行线程池结束,耗时："+(t3-t2));

        for(Future<Result> f : futureList){
            System.out.println(f.get());
        }

        //System.out.println("程序终止:"+System.currentTimeMillis());
        exec.shutdown();

    }



}


class ComputeTask implements Callable<Result>{

    private String name;

    ComputeTask(String name){
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.println("hello:"+name);
        Result result = new Result();
        result.setRspCode("0000");
        result.setRspMsg("成功");
        result.setData(name);
        Thread.sleep(2000);
        return result;
    }
}

class Result<T>{
    private String rspCode;
    private String rspMsg;

    private T data;

    public String getRspMsg() {
        return rspMsg;
    }

    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
