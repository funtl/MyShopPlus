package com.funtl.myshop.plus.business.redis.set;

import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author Gjing
 *
 * 以下可能有部分方法含有参数传Collection的,本案例没有描述,你们可以根据实际参数类型传参
 **/
@Component
public class RedisSet {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 向变量中批量添加值。返回添加的数量
     *
     * add(K key, V... values)
     */
    public void add() {
        Long add = stringRedisTemplate.opsForSet().add("set", "a", "b", "c");
        System.out.println(add);
    }

    /**
     * 获取变量的值
     *
     * members(K key)
     */
    public void members() {
        Set<String> set = stringRedisTemplate.opsForSet().members("set");
        System.out.println(set);
    }

    /**
     * 获取变量中值得长度
     *
     * size(k key)
     */
    public void size() {
        Long size = stringRedisTemplate.opsForSet().size("set");
        System.out.println(size);
    }

    /**
     * 随机获取变量中的某个元素
     *
     * randomMember(k key)
     */
    public void randomMember() {
        String member = stringRedisTemplate.opsForSet().randomMember("set");
        System.out.println(member);
    }

    /**
     * 随机获取变量中指定个数的元素
     *
     * randomMembers(k key, long count)
     */
    public void randomMembers() {
        List<String> members = stringRedisTemplate.opsForSet().randomMembers("set", 2);
        System.out.println(members);
    }

    /**
     * 检查给定的元素是否在变量中,true为存在
     *
     * isMember(k key, object value)
     */
    public void isMember() {
        Boolean member = stringRedisTemplate.opsForSet().isMember("set", "b");
        System.out.println(member);
    }

    /**
     * 转义变量的元素值到另一个变量中
     *
     * move(k key, v value, k targetKey)
     */
    public void move() {
        Boolean move = stringRedisTemplate.opsForSet().move("set", "b", "set2");
        System.out.println(move);
    }

    /**
     * 弹出变量中的元素。当元素全部弹完,变量也会删除
     *
     * pop(k key)
     */
    public void pop() {
        String pop = stringRedisTemplate.opsForSet().pop("set");
        System.out.println(pop);
    }

    /**
     * 批量删除变量中的元素,返回删除的数量
     *
     * remove(k key, v ...values)
     */
    public void remove() {
        Long remove = stringRedisTemplate.opsForSet().remove("set2", "b");
        System.out.println(remove);
    }

    /**
     * 匹配获取键值对，ScanOptions.NONE为获取全部键值对；ScanOptions.scanOptions().match("C").build()匹配获取键位map1的键值对,不能模糊匹配。
     *
     * scan(K key, ScanOptions options)
     */
    public void scan() {
        Cursor<String> set = stringRedisTemplate.opsForSet().scan("set", ScanOptions.NONE);
        while (set.hasNext()) {
            String next = set.next();
            System.out.println(next);
        }
    }

    /**
     * 通过集合求差值。
     *
     * difference(k key, k otherKey)
     */
    public void difference() {
        Set<String> difference = stringRedisTemplate.opsForSet().difference("set", "set2");
        System.out.println(difference);
    }

    /**
     * 将求出来的差值元素保存
     *
     * differenceAndStore(K key, K otherKey, K targetKey)
     */
    public void differenceAndStore() {
        Long aLong = stringRedisTemplate.opsForSet().differenceAndStore("set", "set2", "set3");
        System.out.println(aLong);
    }

    /**
     * 获取去重的随机元素
     *
     * distinctRandomMembers(K key, long count)
     */
    public void distinctRandomMembers() {
        Set<String> set = stringRedisTemplate.opsForSet().distinctRandomMembers("set", 2);
        System.out.println(set);
    }

    /**
     * 获取两个变量中的交集
     *
     * intersect(K key, K otherKey)
     */
    public void intersect() {
        Set<String> intersect = stringRedisTemplate.opsForSet().intersect("set", "set2");
        System.out.println(intersect);
    }

    /**
     * 获取2个变量交集后保存到最后一个变量上。
     *
     * intersectAndStore(K key, K otherKey, K targetKey)
     */
    public void intersectAndStore() {
        Long aLong = stringRedisTemplate.opsForSet().intersectAndStore("set", "set2", "set3");
        System.out.println(aLong);
    }

    /**
     * 获取两个变量的合集
     *
     * union(K key, K otherKey)
     */
    public void union() {
        Set<String> union = stringRedisTemplate.opsForSet().union("set", "set2");
        System.out.println(union);
    }

    /**
     * 获取两个变量合集后保存到另一个变量中
     *
     * unionAndStore(K key, K otherKey, K targetKey)
     */
    public void unionAndStore() {
        Long aLong = stringRedisTemplate.opsForSet().unionAndStore("set", "set2", "set3");
        System.out.println(aLong);
    }
}
