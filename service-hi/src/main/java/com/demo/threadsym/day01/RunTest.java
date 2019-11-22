package com.demo.threadsym.day01;

import com.util.ThreadPoolUtil;

import java.math.BigDecimal;

public class RunTest {
    public static void main(String[] args) throws InterruptedException {
        // 1.0.0
//        MyThread a = new MyThread("A");
//        MyThread b = new MyThread("B");
//        MyThread c = new MyThread("C");
//        a.start();
//        b.start();
//        c.start();

        // 1.0.1
//        Thread t1 = new Thread(new MyThread(), "A");
//        Thread t2 = new Thread(new MyThread(), "B");
//        Thread t3 = new Thread(new MyThread(), "C");
//        Thread t4 = new Thread(new MyThread(), "D");
//        Thread t5 = new Thread(new MyThread(), "E");
//
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();

        //1.0.2 停止线程
//        MyThread myThread = new MyThread();
//        myThread.start();
//        Thread.sleep(2000);
//        myThread.interrupt();

        //1.0.3线程优先级
//        System.out.println("main thread begin priority="
//                + Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
//        System.out.println("main thread end   priority="
//                + Thread.currentThread().getPriority());
//        MyThreadDay01 thread1 = new MyThreadDay01();
//        thread1.start();

        //1.0.4守护线程
        // 守护线程不是立即停止,中间有个缓冲时间！
//        例如1.
//                qq,飞讯等等聊天软件,主程序是非守护线程,而所有的聊天窗口是守护线程
//                ,当在聊天的过程中,直接关闭聊天应用程序时,聊天窗口也会随之关闭,但是不是
//                立即关闭,而是需要缓冲,等待接收到关闭命令后才会执行窗口关闭操作.
//        例如2.
//                jvm中,gc线程是守护线程,作用就是当所有用户自定义线以及主线程执行完毕后,
//                gc线程才停止(再次必须要给你们验证一下,csdn中好多人都人为主线程也是守护线程,其实不是的)
        try {
            MyThreadDay01 thread = new MyThreadDay01();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(3000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
