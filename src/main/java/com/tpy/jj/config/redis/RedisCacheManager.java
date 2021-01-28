package com.tpy.jj.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

public class RedisCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String cache_name) throws CacheException {
        return new RedisCache<K,V>(cache_name);
    }
}
