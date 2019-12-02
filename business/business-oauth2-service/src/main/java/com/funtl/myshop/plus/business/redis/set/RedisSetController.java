package com.funtl.myshop.plus.business.redis.set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
@RequestMapping("/set")
public class RedisSetController {
    @Resource
    private RedisSet redisSet;

    @GetMapping("/add")
    public void add() {
        redisSet.add();
    }

    @GetMapping("/members")
    public void members() {
        redisSet.members();
    }

    @GetMapping("/size")
    public void size() {
        redisSet.size();
    }

    @GetMapping("/randomMember")
    public void randomMember() {
        redisSet.randomMember();
    }

    @GetMapping("/randomMembers")
    public void randomMembers() {
        redisSet.randomMembers();
    }

    @GetMapping("/isMember")
    public void isMember() {
        redisSet.isMember();
    }

    @GetMapping("/move")
    public void move() {
        redisSet.move();
    }

    @GetMapping("/pop")
    public void pop() {
        redisSet.pop();
    }

    @GetMapping("/remove")
    public void remove() {
        redisSet.remove();
    }

    @GetMapping("/scan")
    public void scan() {
        redisSet.scan();
    }

    @GetMapping("/difference")
    public void difference() {
        redisSet.difference();
    }

    @GetMapping("/differenceAndStore")
    public void differenceAndStore() {
        redisSet.differenceAndStore();
    }

    @GetMapping("/distinctRandomMembers")
    public void distinctRandomMembers() {
        redisSet.distinctRandomMembers();
    }

    @GetMapping("/intersect")
    public void intersect() {
        redisSet.intersect();
    }

    @GetMapping("/intersectAndStore")
    public void intersectAndStore() {
        redisSet.intersectAndStore();
    }

    @GetMapping("/union")
    public void union() {
        redisSet.union();
    }

    @GetMapping("/unionAndStore")
    public void unionAndStore() {
        redisSet.unionAndStore();
    }

}
