package com.demo.threadsym.day01;

public class MyThreadDay02 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread2 run priority=" + this.getPriority());
    }
}
