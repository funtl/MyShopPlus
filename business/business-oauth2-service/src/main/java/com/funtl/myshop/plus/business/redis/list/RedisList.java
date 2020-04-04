package com.funtl.myshop.plus.business.redis.list;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Gjing
 **/
@Component
public class RedisList {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 在变量左边添加元素值。如果key不存在会新建，添加成功返回添加后的总个数
     *
     * leftPush(K key, V value)
     */
    public void leftPush() {
        Long aLong = stringRedisTemplate.opsForList().leftPush("list", "a");
        System.out.println(aLong);
    }

    /**
     * 向左边批量添加参数元素，如果key不存在会新建，添加成功返回添加后的总个数
     *
     * leftPushAll(K key, V... values)
     */
    public void leftPushAll() {
        Long pushAll = stringRedisTemplate.opsForList().leftPushAll("list", "e", "f", "g");
        System.out.println(pushAll);
    }

    /**
     * 向集合最右边添加元素。如果key不存在会新建，添加成功返回添加后的总个数
     *
     * rightPush(K key, V value)
     */
    public void rightPush() {
        Long aLong = stringRedisTemplate.opsForList().rightPush("list2", "a");
        System.out.println(aLong);
    }


    /**
     * 如果存在集合则添加元素。
     *
     * leftPushIfPresent(K key, V value)
     */
    public void leftPushIfPresent() {
        Long aLong = stringRedisTemplate.opsForList().leftPushIfPresent("list", "h");
        System.out.println(aLong);
    }

    /**
     * 向右边批量添加元素。返回当前集合元素总个数
     *
     * rightPushAll(K key, V... values)
     */
    public void rightPushAll() {
        Long aLong = stringRedisTemplate.opsForList().rightPushAll("list2", "b", "c", "d");
        System.out.println(aLong);
    }

    /**
     * 向已存在的集合中添加元素。返回集合总元素个数
     *
     * rightPushIfPresent(K key, V value)
     */
    public void rightPushIfPresent() {
        Long aLong = stringRedisTemplate.opsForList().rightPushIfPresent("list", "e");
        System.out.println(aLong);
    }

    /**
     * 获取集合长度
     *
     * size(K key)
     */
    public void size() {
        Long size = stringRedisTemplate.opsForList().size("list2");
        System.out.println(size);
    }

    /**
     * 移除集合中的左边第一个元素。返回删除的元素，如果元素为空，该集合会自动删除
     *
     * leftPop(K key)
     */
    public void leftPop() {
        String pop = stringRedisTemplate.opsForList().leftPop("list2");
        System.out.println(pop);
    }

    /**
     * 移除集合中左边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * leftPop(K key, long timeout, TimeUnit unit)
     */
    public void leftPopWait() {
        String pop = stringRedisTemplate.opsForList().leftPop("list2", 10, TimeUnit.SECONDS);
        System.out.println(pop);
    }

    /**
     * 移除集合中右边的元素。返回删除的元素，如果元素为空，该集合会自动删除
     *
     * rightPop(K key)
     */
    public void rightPop() {
        String pop = stringRedisTemplate.opsForList().rightPop("list2");
        System.out.println(pop);
    }

    /**
     * 移除集合中右边的元素在等待的时间里，如果超过等待的时间仍没有元素则退出。
     *
     * rightPop(K key, long timeout, TimeUnit unit)
     */
    public void rightPopWait() {
        String pop = stringRedisTemplate.opsForList().rightPop("list2", 10, TimeUnit.SECONDS);
        System.out.println(pop);
    }

    /**
     * 移除第一个集合右边的一个元素，插入第二个集合左边插入这个元素
     *
     * rightPopAndLeftPush(K sourceKey, K destinationKey)
     */
    public void rightPopAndLeftPush() {
        String s = stringRedisTemplate.opsForList().rightPopAndLeftPush("list2", "list3");
        System.out.println(s);
    }

    /**
     * 在集合的指定位置插入元素,如果指定位置已有元素，则覆盖，没有则新增，超过集合下标+n则会报错。
     *
     * set(K key, long index, V value)
     */
    public void set() {
        stringRedisTemplate.opsForList().set("list2", 2, "w");
    }

    /**
     * 从存储在键中的列表中删除等于值的元素的第一个计数事件。count> 0：删除等于从左到右移动的值的第一个元素；
     * count< 0：删除等于从右到左移动的值的第一个元素；count = 0：删除等于value的所有元素
     *
     * remove(K key, long count, Object value)
     */
    public void remove() {
        Long remove = stringRedisTemplate.opsForList().remove("list2", 2, "w");
        System.out.println(remove);
    }

    /**
     * 截取集合元素长度，保留长度内的数据。
     *
     * trim(K key, long start, long end)
     */
    public void trim() {
        stringRedisTemplate.opsForList().trim("list2", 0, 3);
    }

    /**
     * 获取集合指定位置的值。
     *
     * index(K key, long index)
     */
    public void index() {
        Object listValue = stringRedisTemplate.opsForList().index("list2", 3);
        System.out.println(listValue);
    }

    /**
     * 获取指定区间的值。
     *
     * range(K key, long start, long end)
     */
    public void range() {
        List<String> list = stringRedisTemplate.opsForList().range("list", 0, -1);
        System.out.println(list);
    }

    /**
     * 删除指定集合,返回true删除成功
     *
     * delete(K key)
     */
    public void delete() {
        Boolean delete = stringRedisTemplate.opsForList().getOperations().delete("list2");
        System.out.println(delete);
    }
}
