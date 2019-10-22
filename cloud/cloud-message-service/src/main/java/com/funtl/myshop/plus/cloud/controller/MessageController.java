package com.funtl.myshop.plus.cloud.controller;

import com.funtl.myshop.plus.cloud.producer.MessageProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "message")
public class MessageController {

    @Resource
    private MessageProducer messageProducer;
}
