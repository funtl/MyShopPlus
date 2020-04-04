package com.funtl.myshop.plus.business.redis.string;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
public class RedisStringController {

    @Resource
    private RedisString redisString;

    @GetMapping("/set")
    public void set() {
        redisString.set();
    }

    @GetMapping("/setA")
    public void setAbsent() {
        redisString.setIfAbsent();
    }

    @GetMapping("/setM")
    public void setMulti() {
        redisString.multiSet();
    }

    @GetMapping("/setMA")
    public void setMultiA() {
        redisString.multiSetIfAbsent();
    }

    @GetMapping("/get")
    public void get() {
        redisString.get();
    }

    @GetMapping("/getM")
    public void getMulti() {
        redisString.multiGet();
    }

    @GetMapping("/append")
    public void append() {
        redisString.append();
    }

    @GetMapping("/getLength")
    public void getLength() {
        redisString.getLength();
    }

    @GetMapping("/getSet")
    public void getSet() {
        redisString.getAndSet();
    }

    @GetMapping("/decrement")
    public void decrement() {
        redisString.decrement();
    }

    @GetMapping("/increment")
    public void increment() {
        redisString.increment();
    }

    @GetMapping("/delete")
    public void delete() {
        redisString.delete();
    }

    @GetMapping("/deleteMulti")
    public void deleteMulti() {
        redisString.deleteMulti();
    }
}
