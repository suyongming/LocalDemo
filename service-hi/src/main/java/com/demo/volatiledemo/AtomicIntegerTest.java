package com.demo.volatiledemo;

import java.util.concurrent.CountDownLatch;

/**
 * 需求:保证为1000000
 *      处于性能考虑 优先使用原子类 AtomicInteger 来自增 它使用的是 CAS 算法，效率优于同步锁
 *     1.public static final AtomicInteger count = new AtomicInteger(0); getAndIncrement();
 *     2.方法加上synchronized
 */
public class AtomicIntegerTest {
    static int count = 0;
    static CountDownLatch cdl = new CountDownLatch(1000);

    public static void main(String[] args) throws Exception {

        CountRunnable countRunnable = new CountRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(countRunnable).start();
        }

        cdl.await();
        System.out.println(count);
    }


    static class CountRunnable implements Runnable {

        private void count() {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        }

        @Override
        public void run() {
            count();
            cdl.countDown();
        }

    }
}
