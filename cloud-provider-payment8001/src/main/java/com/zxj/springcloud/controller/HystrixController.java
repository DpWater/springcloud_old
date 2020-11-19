package com.zxj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class HystrixController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok")
    public String paymentInfo_OK(){
        System.out.println("线程池："+Thread.currentThread().getName()+"   paymentInfo_OK"+"\t"+"哈哈哈");
         return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK"+"\t"+"哈哈哈"  ;
    }
    @GetMapping("/payment/hystrix/timeout")
    public String paymentInfo_TimeOut(){
        int timeNumber = 3;
        try { TimeUnit.SECONDS.sleep(timeNumber); }catch (Exception e) {e.printStackTrace();}
        System.out.println("线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut"+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber);

        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut"+"\t"+"呜呜呜"+" 耗时(秒)"+timeNumber;
    }

}
