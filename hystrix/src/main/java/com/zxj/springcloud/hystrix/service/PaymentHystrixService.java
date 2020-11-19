package com.zxj.springcloud.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok")
    public String paymentInfo_OK();

    @GetMapping("/payment/hystrix/timeout")
    public String paymentInfo_TimeOut();


}
