package com.tpy.jj.client;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisClient {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        System.out.println(redisTemplate);
    }

}
