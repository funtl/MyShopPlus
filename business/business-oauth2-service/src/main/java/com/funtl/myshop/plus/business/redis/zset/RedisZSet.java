package com.funtl.myshop.plus.business.redis.zset;

import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Gjing
 *
 **/
@Component
public class RedisZSet {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 添加元素到变量中同时指定元素的分值。
     *
     * add(K key, V value, double score)
     */
    public void add() {
        Boolean add = stringRedisTemplate.opsForZSet().add("zset", "a", 1);
        System.out.println(add);
    }

    /**
     * 通过TypedTuple方式新增数据。
     *
     * add(K key, Set<ZSetOperations.TypedTuple<V>> tuples)
     */
    public void addByTypedTuple() {
        ZSetOperations.TypedTuple<String> typedTuple1 = new DefaultTypedTuple<>("E", 2.0);
        ZSetOperations.TypedTuple<String> typedTuple2 = new DefaultTypedTuple<>("F", 3.0);
        ZSetOperations.TypedTuple<String> typedTuple3 = new DefaultTypedTuple<>("G", 5.0);
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        typedTupleSet.add(typedTuple1);
        typedTupleSet.add(typedTuple2);
        typedTupleSet.add(typedTuple3);
        Long zset = stringRedisTemplate.opsForZSet().add("zset", typedTupleSet);
        System.out.println(zset);
    }

    /**
     * 获取指定区间的元素
     *
     * range(k key, long start, long end)
     */
    public void range() {
        Set<String> zset = stringRedisTemplate.opsForZSet().range("zset", 0, -1);
        System.out.println(zset);
    }

    /**
     * 用于获取满足非score的排序取值。这个排序只有在有相同分数的情况下才能使用，如果有不同的分数则返回值不确定。
     *
     * rangeByLex(K key, RedisZSetCommands.Range range)
     */
    public void rangeByLex() {
        Set<String> rangeByLex = stringRedisTemplate.opsForZSet().rangeByLex("zset", RedisZSetCommands.Range.range().lt("E"));
        System.out.println(rangeByLex);
    }

    /**
     * 用于获取满足非score的设置下标开始的长度排序取值。
     *
     * rangeByLex(k key, range range, limit limit)
     */
    public void rangeByLexAndLimit() {
        Set<String> zset = stringRedisTemplate.opsForZSet().rangeByLex("zset", RedisZSetCommands.Range.range().lt("E"),
                RedisZSetCommands.Limit.limit().offset(1).count(2));
        System.out.println(zset);
    }

    /**
     * 根据设置的score获取区间值。
     *
     * rangeByScore(K key, double min, double max)
     */
    public void rangeByScore() {
        Set<String> zset = stringRedisTemplate.opsForZSet().rangeByScore("zset", 1, 3);
        System.out.println(zset);
    }

    /**
     * 获取RedisZSetCommands.Tuples的区间值。
     *
     * rangeWithScores(K key, long start, long end)
     */
    public void rangeWithScores() {
        Set<ZSetOperations.TypedTuple<String>> zset = stringRedisTemplate.opsForZSet().rangeWithScores("zset", 1, 3);
        assert zset != null;
        for (ZSetOperations.TypedTuple<String> next : zset) {
            String value = next.getValue();
            Double score = next.getScore();
            System.out.println(value + "-->" + score);
        }
    }

    /**
     * 获取区间值的个数。
     *
     * count(k key, double min, double max)
     */
    public void count() {
        Long zset = stringRedisTemplate.opsForZSet().count("zset", 1, 3);
        System.out.println(zset);
    }

    /**
     * 获取变量中指定元素的索引,下标开始为0
     *
     * rank(k key, object o)
     */
    public void rank() {
        Long rank = stringRedisTemplate.opsForZSet().rank("zset", "a");
        System.out.println(rank);
    }

    /**
     * 匹配获取键值对，ScanOptions.NONE为获取全部键值对；ScanOptions.scanOptions().match("C").build()匹配获取键位map1的键值对,不能模糊匹配。
     *
     * scan(K key, ScanOptions options)
     */
    public void scan() {
        Cursor<ZSetOperations.TypedTuple<String>> zset = stringRedisTemplate.opsForZSet().scan("zset", ScanOptions.NONE);
        while (zset.hasNext()) {
            ZSetOperations.TypedTuple<String> next = zset.next();
            System.out.println(next.getValue() + "-->" + next.getScore());
        }
    }

    /**
     * 获取指定元素的分值
     *
     * score(k key, object o)
     */
    public void score() {
        Double score = stringRedisTemplate.opsForZSet().score("zset", "a");
        System.out.println(score);
    }

    /**
     * 获取变量中元素的个数
     *
     * zCard(k key)
     */
    public void zCard() {
        Long zset = stringRedisTemplate.opsForZSet().zCard("zset");
        System.out.println(zset);
    }

    /**
     * 修改变量中元素的分值
     *
     * incrementScore(K key, V value, double delta)
     */
    public void incrementScore() {
        Double score = stringRedisTemplate.opsForZSet().incrementScore("zset", "a", 2);
        System.out.println(score);
    }

    /**
     * 索引倒序排列指定区间的元素
     *
     * reverseRange(K key, long start, long end)
     */
    public void reverseRange() {
        Set<String> zset = stringRedisTemplate.opsForZSet().reverseRange("zset", 1, 3);
        System.out.println(zset);
    }

    /**
     * 倒序排列指定分值区间的元素
     *
     * reverseRangeByScore(K key, double min, double max)
     */
    public void reverseRangeByScore() {
        Set<String> zset = stringRedisTemplate.opsForZSet().reverseRangeByScore("zset", 1, 3);
        System.out.println(zset);
    }

    /**
     * 倒序排序获取RedisZSetCommands.Tuples的分值区间值
     *
     * reverseRangeByScore(K key, double min, double max, long offset, long count)
     */
    public void reverseRangeByScoreLength() {
        Set<String> zset = stringRedisTemplate.opsForZSet().reverseRangeByScore("zset", 1, 3, 1, 2);
        System.out.println(zset);
    }

    /**
     * 倒序排序获取RedisZSetCommands.Tuples的分值区间值。
     *
     * reverseRangeByScoreWithScores(K key, double min, double max)
     */
    public void reverseRangeByScoreWithScores() {
        Set<ZSetOperations.TypedTuple<String>> zset = stringRedisTemplate.opsForZSet().reverseRangeByScoreWithScores("zset", 1, 5);
        assert zset != null;
        zset.iterator().forEachRemaining(e-> System.out.println(e.getValue() + "--->" + e.getScore()));
    }

    /**
     * 获取倒序排列的索引值
     *
     * reverseRank(k key, object o)
     */
    public void reverseRank() {
        Long aLong = stringRedisTemplate.opsForZSet().reverseRank("zset", "a");
        System.out.println(aLong);
    }

    /**
     * 获取2个变量的交集存放到第3个变量里面。
     *
     * intersectAndStore(K key, K otherKey, K destKey)
     */
    public void intersectAndStore() {
        Long aLong = stringRedisTemplate.opsForZSet().intersectAndStore("zset", "zset2", "zset3");
        System.out.println(aLong);
    }

    /**
     * 获取2个变量的合集存放到第3个变量里面。 返回操作的数量
     *
     * unionAndStore(K key, K otherKey, K destKey)
     */
    public void unionAndStore() {
        Long aLong = stringRedisTemplate.opsForZSet().unionAndStore("zset", "zset2", "zset3");
        System.out.println(aLong);
    }


    /**
     * 批量移除元素根据元素值。返回删除的元素数量
     *
     * remove(K key, Object... values)
     */
    public void remove() {
        Long remove = stringRedisTemplate.opsForZSet().remove("zset", "a", "b");
        System.out.println(remove);
    }

    /**
     * 根据分值移除区间元素。返回删除的数量
     *
     * removeRangeByScore(k key, double min, double max)
     */
    public void removeRangeByScore() {
        Long zset = stringRedisTemplate.opsForZSet().removeRangeByScore("zset", 1, 3);
        System.out.println(zset);
    }

    /**
     * 根据索引值移除区间元素。返回移除的元素集合
     *
     * removeRange(K key, long start, long end)
     */
    public void removeRange() {
        Set<String> zset = stringRedisTemplate.opsForZSet().reverseRange("zset", 0, 4);
        System.out.println(zset);
    }
}
