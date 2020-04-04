//package com.funtl.myshop.plus.business.configure;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.lang.reflect.Method;
//
///**
// * @PackgeName: com.funtl.myshop.plus.business.configure
// * @ClassName: RedisConfig
// * @Author: Administrator
// * Date: 2019/12/1 0001 10:49
// * project name: MyShopPlus
// * @Version:
// * @Description:
// */
//@Configuration
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//    @Autowired
//    private RedisConnectionFactory factory;
//    @Autowired
//    private RedisSerializer fastJson2JsonRedisSerializer;
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : params) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        //rcm.setDefaultExpiration(60);//秒
//        return rcm;
//    }
//
//
//    //fastjson
//    @Bean(name="redisTemplate")
//    public RedisTemplate<String, Object> fastJsonRedisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(factory);
//        //redis开启事务
//        template.setEnableTransactionSupport(true);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(fastJson2JsonRedisSerializer);
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(fastJson2JsonRedisSerializer);
//        template.setDefaultSerializer(new StringRedisSerializer());
//        template.afterPropertiesSet();
//        return template;
//    }
//
//}
