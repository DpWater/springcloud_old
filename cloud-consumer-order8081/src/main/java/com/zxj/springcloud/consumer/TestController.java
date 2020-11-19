package com.zxj.springcloud.consumer;

import com.zxj.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("consumer")
    public ResponseEntity<CommonResult>  getLoadBalanced(){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity("http://cloud-payment-service/test/testFunction", CommonResult.class);
        return forEntity;

    }



}
