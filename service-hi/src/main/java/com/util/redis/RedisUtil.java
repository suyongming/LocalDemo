package com.util.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * redis通用工具类.
 */
@Slf4j
public class RedisUtil {

    /**
     * 设置key的有效期，单位是秒.
     *
     * @param key    要设置的键
     * @param exTime 过期时间(s)
     * @return
     */
    public static Long expire(String key, int exTime) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.expire(key, exTime);
        } catch (Exception e) {
            log.error("expire key:{} error", key, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * 存入key value，指定过期时间.
     *
     * @param key    要存入的键
     * @param value  要存入的值
     * @param exTime 过期时间(s)
     * @return
     */
    public static String setEx(String key, String value, int exTime) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setex(key, exTime, value);
        } catch (Exception e) {
            log.error("setex key:{} value:{} error", key, value, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * 设置redis key value.
     *
     * @param key   要设置的键
     * @param value 要设置的值
     * @return
     */
    public static String set(String key, String value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key, value);
        } catch (Exception e) {
            log.error("set key:{} value:{} error", key, value, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * 获取指定的key.
     *
     * @param key 要获取的key.
     * @return
     */
    public static String get(String key) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("get key:{} error", key, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * 删除指定key.
     *
     * @param key 要删除的key.
     * @return
     */
    public static Long del(String key) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("del key:{} error", key, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * SETNX.
     * @param key 键
     * @param value 值
     * @return
     */
    public static Long setNx(String key, String value) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setnx(key, value);
        } catch (Exception e) {
            log.error("setnx key:{} error", key, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * GETSET.
     * @param key 键
     * @param value 值
     * @return
     */
    public static String getSet(String key, String value) {
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.getSet(key, value);
        } catch (Exception e) {
            log.error("getSet key:{} error", key, e);
        } finally {
            RedisPool.close(jedis);
        }
        return result;
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        Jedis jedis = RedisPool.getJedis();
        jedis.setex("openId_123456@123456", 1800, "123456@123456");
        System.out.println("end");
        System.out.println(jedis.get("openId_123456@123456"));
    }
}