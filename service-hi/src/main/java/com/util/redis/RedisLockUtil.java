package com.util.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 基于Redis.SETNX分布式锁.
 */
@Component
@Slf4j
public class RedisLockUtil {

    /**
     * 当前请求时间间隔.
     */
    private static final long LOCK_TIME_DIFF = 60000L;
    /**
     * 删除锁时间间隔.
     */
    private static final long DEL_TIME_DIFF = 10000L;
    /**
     * 锁过期时间.
     */
    private static final int EXPIRE_TIME_DIFF = 60;

    /**
     * 上锁.
     *
     * @param lockKey 上锁对象
     * @return
     */
    public synchronized boolean tryLock(String lockKey) {
        long currentTime = System.currentTimeMillis();
        //加锁的持续时间
        String lockTime = String.valueOf(currentTime);
        Long result = RedisUtil.setNx(lockKey, lockTime);
        if (result == 1) {
            return true;
        } else {
            //先查询上次的锁是否已经超时
            long timeDiff = currentTime - Long.parseLong(RedisUtil.get(lockKey));
            //如果删除锁失败，此处需要重新设置超时时间
            if (LOCK_TIME_DIFF < timeDiff) {
                //重新设置超时时间并返回上次设置的时间
                String preTime = RedisUtil.getSet(lockKey,
                        String.valueOf(currentTime + LOCK_TIME_DIFF + LOCK_TIME_DIFF));
                return LOCK_TIME_DIFF < (currentTime - Long.parseLong(preTime));
            }
            return false;
        }
    }

    /**
     * 释放锁.
     *
     * @param lockKey 上锁对象
     */
    public synchronized void releaseLock(String lockKey) {
        //防止第一个线程删除了锁，后面的线程才执行获取锁部分
        long timeDiff = System.currentTimeMillis() - Long.parseLong(RedisUtil.get(lockKey));
        if (DEL_TIME_DIFF < timeDiff) {
            RedisUtil.del(lockKey);
        } else {
            RedisUtil.expire(lockKey, EXPIRE_TIME_DIFF);
        }
    }

    /**
     * 释放锁，直接删除key.
     * @param lockKey 上锁对象
     */
    public synchronized void deleteLockKey(String lockKey) {
        RedisUtil.del(lockKey);
    }
}
