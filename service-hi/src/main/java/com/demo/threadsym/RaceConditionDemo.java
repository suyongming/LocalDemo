package com.demo.threadsym;

/**
 * 竞态（Race Condition）是指计算的正确性依赖于相对时间顺序或者线程的交错。
 * 根据这个定义可知，竞态不一定就导致计算结果的不正确，
 * 它只是不排除计算结果时而正确时而错误的可能。
 * @author suyon
 * @date 2019-11-18 10:11
 */
public class RaceConditionDemo {
    /**
     * 例子其实是一种竞态的典型模式，它被称为read-modify-write。该操作可被细分为这样几个步骤：
     * 读取一个共享变量的值（read）,
     * 然后根据该值做一些计算（modify）,
     * 接着更新该共享变量的值（write）。
     * 一个线程在执行完read操作后到开始执行write操作前的这段时间内其他线程可能已经更新了共享变量的值，
     * 但是该线程把根据旧值计算出来的结果更新到共享变量，
     * 这使得其他线程对该共享变量所做的更新被“覆盖”，即造成了更新丢失。
     * */
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + Counter.getInstance().count());

            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


}

class Counter {
    private static final Counter INSTANCE = new Counter();
    private int countValue = 0;

    private Counter() {}

    int count() {
        if (countValue >= 100) {
            countValue = 1;
        } else {
            countValue++;
        }
        return countValue;
    }

    static Counter getInstance() {
        return INSTANCE;
    }
}


