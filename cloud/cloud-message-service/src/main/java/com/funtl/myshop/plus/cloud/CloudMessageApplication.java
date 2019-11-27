package com.funtl.myshop.plus.cloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRabbit
//@EnableBinding({MessageSource.class})
public class CloudMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMessageApplication.class, args);
    }
}
