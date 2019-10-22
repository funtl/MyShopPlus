package com.funtl.myshop.plus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackageClasses = {BusinessOAuth2Application.class}, scanBasePackages = "com.funtl.myshop.plus.cloud.feign")
public class BusinessOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOAuth2Application.class, args);
    }

}
