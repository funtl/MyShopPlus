package com.funtl.myshop.plus.business.redis.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
public class RedisListController {
    @Resource
    private RedisList redisList;

    @GetMapping("/leftPush")
    public void leftPush() {
        redisList.leftPush();
    }

    @GetMapping("/leftPushAll")
    public void leftPushAll() {
        redisList.leftPushAll();
    }

    @GetMapping("/rightPush")
    public void rightPush() {
        redisList.rightPush();
    }

    @GetMapping("/leftPushIfPresent")
    public void leftPushIfPresent() {
        redisList.leftPushIfPresent();
    }

    @GetMapping("/rightPushAll")
    public void rightPushAll() {
        redisList.rightPushAll();
    }

    @GetMapping("/rightPushIfPresent")
    public void rightPushIfPresent() {
        redisList.rightPushIfPresent();
    }

    @GetMapping("/size")
    public void size() {
        redisList.size();
    }
    @GetMapping("/leftPop")
    public void leftPop() {
        redisList.leftPop();
    }

    @GetMapping("/leftPopWait")
    public void leftPopWait() {
        redisList.leftPopWait();
    }

    @GetMapping("/rightPop")
    public void rightPop() {
        redisList.rightPop();
    }

    @GetMapping("/rightPopWait")
    public void rightPopWait() {
        redisList.rightPopWait();
    }

    @GetMapping("/rightPopAndLeftPush")
    public void rightPopAndLeftPush() {
        redisList.rightPopAndLeftPush();
    }

    @GetMapping("/list-set")
    public void set() {
        redisList.set();
    }

    @GetMapping("/remove")
    public void remove() {
        redisList.remove();
    }

    @GetMapping("/trim")
    public void trim() {
        redisList.trim();
    }

    @GetMapping("/index")
    public void index() {
        redisList.index();
    }

    @GetMapping("/range")
    public void range() {
        redisList.range();
    }

    @GetMapping("/list-delete")
    public void listDelete() {
        redisList.delete();
    }
}
