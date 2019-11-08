package com.demo.threadsym.day01;

public class MyRunnable implements Runnable{
    static int i = 0;
    @Override
    public void run() {

        System.out.println("MyRunnable"+ i);
    }



}
