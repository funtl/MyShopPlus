package com.funtl.myshop.plus.business.redis.zset;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
@RequestMapping("/zset")
public class ZsetController {
    @Resource
    private RedisZSet redisZSet;

    @GetMapping("/add")
    public void add() {
        redisZSet.add();
    }

    @GetMapping("/addByTypedTuple")
    public void addByTypedTuple() {
        redisZSet.addByTypedTuple();
    }

    @GetMapping("/range")
    public void range() {
        redisZSet.range();
    }

    @GetMapping("/rangeByLex")
    public void rangeByLex() {
        redisZSet.rangeByLex();
    }

    @GetMapping("/rangeByLexAndLimit")
    public void rangeByLexAndLimit() {
        redisZSet.rangeByLexAndLimit();
    }

    @GetMapping("/rangeByScore")
    public void rangeByScore() {
        redisZSet.rangeByScore();
    }

    @GetMapping("/rangeWithScores")
    public void rangeWithScores() {
        redisZSet.rangeWithScores();
    }

    @GetMapping("/count")
    public void count() {
        redisZSet.count();
    }

    @GetMapping("/rank")
    public void rank() {
        redisZSet.rank();
    }

    @GetMapping("/scan")
    public void scan() {
        redisZSet.scan();
    }

    @GetMapping("/score")
    public void score() {
        redisZSet.score();
    }

    @GetMapping("/zCard")
    public void zCard() {
        redisZSet.zCard();
    }

    @GetMapping("/incrementScore")
    public void incrementScore() {
        redisZSet.incrementScore();
    }

    @GetMapping("/reverseRange")
    public void reverseRange() {
        redisZSet.reverseRange();
    }

    @GetMapping("/reverseRangeByScore")
    public void reverseRangeByScore() {
        redisZSet.reverseRangeByScore();
    }

    @GetMapping("/reverseRangeByScoreLength")
    public void reverseRangeByScoreLength() {
        redisZSet.reverseRangeByScoreLength();
    }

    @GetMapping("/reverseRangeByScoreWithScores")
    public void reverseRangeByScoreWithScores() {
        redisZSet.reverseRangeByScoreWithScores();
    }

    @GetMapping("/reverseRank")
    public void reverseRank() {
        redisZSet.reverseRank();
    }

    @GetMapping("/intersectAndStore")
    public void intersectAndStore() {
        redisZSet.intersectAndStore();
    }

    @GetMapping("/unionAndStore")
    public void unionAndStore() {
        redisZSet.unionAndStore();
    }

    @GetMapping("/remove")
    public void remove() {
        redisZSet.remove();
    }

    @GetMapping("/removeRangeByScore")
    public void removeRangeByScore() {
        redisZSet.removeRangeByScore();
    }

    @GetMapping("/removeRange")
    public void removeRange() {
        redisZSet.removeRange();
    }

}
