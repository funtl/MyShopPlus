package com.funtl.myshop.plus.business.redis.hash;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
@RequestMapping("/hash")
public class RedisHashController {
    @Resource
    private RedisHash redisHash;

    @GetMapping("/put")
    public void hashPut() {
        redisHash.put();
    }

    @GetMapping("/hashPutAll")
    public void hashPutAll() {
        redisHash.putAll();
    }

    @GetMapping("/putIfAbsent")
    public void putIfAbsent() {
        redisHash.putIfAbsent();
    }

    @GetMapping("/values")
    public void values() {
        redisHash.values();
    }

    @GetMapping("/entries")
    public void entries() {
        redisHash.entries();
    }

    @GetMapping("/get")
    public void get() {
        redisHash.get();
    }

    @GetMapping("/keys")
    public void keys() {
        redisHash.keys();
    }

    @GetMapping("/size")
    public void size() {
        redisHash.size();
    }

    @GetMapping("/increment")
    public void increment() {
        redisHash.increment();
    }

    @GetMapping("/multiGet")
    public void multiGet() {
        redisHash.multiGet();
    }

    @GetMapping("/scan")
    public void scan() {
        redisHash.scan();
    }

    @GetMapping("/delete")
    public void delete() {
        redisHash.delete();
    }

}
