package com.zxj.springcloud.controller;

import com.zxj.common.CommonResult;
import com.zxj.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestController {


    @Autowired
    private TestService testService;

    @Value(value = "${eureka.instance.instance-id}")
    private String instanceId;


    @RequestMapping(value = "/testFunction")
     public CommonResult test(){
        List<HashMap<String, String>> test = testService.test();
        CommonResult commonResult = new CommonResult(test);
        commonResult.setMessage(instanceId);
        return commonResult
                ;
    }


}
