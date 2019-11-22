package com.util;

import java.util.concurrent.*;

/**
 * 线程池管理工具类.
 * @author FangSo
 */
public class ThreadPoolUtil {

    /** 根据cpu的数量动态的配置核心线程数和最大线程数. */
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    /** 核心线程数 = CPU核心数 + 1. */
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;

    /** 核心线程数 = CPU核心数 + 1. */
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;

    /** 非核心线程闲置时超时1s. */
    private static final int KEEP_ALIVE = 1;

    /** ThreadPoolExecutor. */
    public static ThreadPoolExecutor threadPool;
//    public volatile static ThreadPoolExecutor threadPool;


    /**
     * 无返回值直接执行.
     * @param runnable 执行对象
     */
    public static void execute(Runnable runnable) {
        getThreadPool().execute(runnable);
    }

    /**
     * 返回值直接执行.
     * @param callable 带有返回值对象
     */
    public static <T> Future<T> submit(Callable<T> callable) {
        return getThreadPool().submit(callable);
    }

    /**
     * 单例获取线程池.
     * @return 线程池对象
     */
    public static ThreadPoolExecutor getThreadPool() {
        //首先判断是否为空
        if(threadPool==null) {
            //可能多个线程同时进入到这一步进行阻塞等待
            synchronized(ThreadPoolUtil.class) {
                //第一个线程拿到锁，判断不为空进入下一步
                if(threadPool==null) {
                    /**
                     * 由于编译器的优化、JVM的优化、操作系统处理器的优化，可能会导致指令重排（happen-before规则下的指令重排，执行结果不变，指令顺序优化排列）
                     * new Singleton3()这条语句大致会有这三个步骤：
                     * 1.在堆中开辟对象所需空间，分配内存地址
                     * 2.根据类加载的初始化顺序进行初始化
                     * 3.将内存地址返回给栈中的引用变量
                     *
                     * 但是由于指令重排的出现，这三条指令执行顺序会被打乱，可能导致3的顺序和2调换
                     * 👇
                     */
                    threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS,
                            new LinkedBlockingQueue<>(32), new ThreadPoolExecutor.CallerRunsPolicy());
                }
            }
        }
        return threadPool;

//        if (threadPool != null) {
//            return threadPool;
//        } else {
//            synchronized (ThreadPoolUtil.class) {
//                if (threadPool == null) {
//                    threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE, TimeUnit.SECONDS,
//                            new LinkedBlockingQueue<>(32), new ThreadPoolExecutor.CallerRunsPolicy());
//                }
//                return threadPool;
//            }
//        }
    }
}
