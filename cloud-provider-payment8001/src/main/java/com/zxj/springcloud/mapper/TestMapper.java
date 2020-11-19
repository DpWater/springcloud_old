package com.zxj.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TestMapper {

    List<HashMap<String,String>> test() ;

}
