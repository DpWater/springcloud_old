package com.zxj.springcloud.consumer;

import com.zxj.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-order-service" , configuration = MySelfRule.class)
public class ConsumerApplication {

	public static void main(String[] args) {
 		SpringApplication.run(ConsumerApplication.class, args);
	}

}
