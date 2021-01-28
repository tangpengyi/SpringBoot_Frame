package com.tpy.jj.controller;

import com.tpy.jj.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("redis")
    public String isRedis(){
        log.info(redisTemplate == null ? "为空":redisTemplate.toString());
        Object new_redisTemplate = SpringUtils.getBean("redisTemplate");
        log.info(new_redisTemplate == null ? "为空": new_redisTemplate.toString());
        return "redis hello";
    }

}
