package com.zxj.springcloud.service.impl;

import com.zxj.springcloud.mapper.TestMapper;
import com.zxj.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;


    @Override
    public List<HashMap<String, String>> test() {
        List<HashMap<String, String>> test = testMapper.test();
        return test;
    }
}
