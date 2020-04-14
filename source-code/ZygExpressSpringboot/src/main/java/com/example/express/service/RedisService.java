package com.example.express.service;

import java.util.concurrent.TimeUnit;

/**
 * 基于RedisTemplate
 */
public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

    /**
     * API接口限制
     * @param key
     * @param expireTime
     * @param max  规定时间最大访问次数
     * @param timeUnit
     * @param userAgent
     * @return
     */
    boolean checkRequestRateLimit(final String key, final int expireTime, final int max, TimeUnit timeUnit, String userAgent);



}
