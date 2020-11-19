package com.zxj.springcloud.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zxj.springcloud.hystrix.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j

public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consumer/payment/hystrix/ok")

    public String paymentInfo_OK(){
        String result = paymentHystrixService.paymentInfo_OK();
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout")
    //失败
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String paymentInfo_TimeOut(){
        String result = paymentHystrixService.paymentInfo_TimeOut();
        return result;
    }

    //兜底方法
    public String paymentInfo_TimeOutHandler(){
        return "线程池："+Thread.currentThread().getName()+"   系统繁忙, 请稍候再试  ,"+"\t"+"哭了哇呜";
    }


}
