package com.util.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis连接池.
 */
@Slf4j
public class RedisPool {

    /**
     * pool.
     */
    private static JedisPool pool;


    private static void initPool() {
        pool = new JedisPool();
    }

    static {
        initPool();
    }

    /**
     * getJedis.
     */
    public static Jedis getJedis() {
        return pool.getResource();
    }

    /**
     * close.
     */
    public static void close(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
            log.error("return redis resource exception", e);
        }
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        Jedis jedis = pool.getResource();
        jedis.set("123", "123");
        close(jedis);
        System.out.println(jedis.get("123"));

        pool.destroy();// 临时调用，销毁连接池中的所有连接
    }
}
