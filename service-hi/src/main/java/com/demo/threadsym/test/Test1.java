package com.demo.threadsym.test;

import lombok.Data;

/**
 * 设计一个多线程的程序如下：设计一个火车售票模拟程序。
 *  1.假如火车站要有100张火车票要卖出，现在有5个售票点同时售票，用5个线程模拟这5个售票点的售票情况
 *  2.统计每个售票点 一共卖了几张票
 * @author suyon
 * @date 2019-12-02 11:42
 */
public class Test1 {
    public static void main(String[] args){



        new Thread(new ResourcesTicket(),"person1").start();
        new Thread(new ResourcesTicket(),"person2").start();
        new Thread(new ResourcesTicket(),"person3").start();
        new Thread(new ResourcesTicket(),"person4").start();
        new Thread(new ResourcesTicket(),"person5").start();

    }
}

class ResourcesTicket implements Runnable{
    private volatile static int ticket = 100;

    @Override
    public void run(){
        int count = 0;
        String threadName = Thread.currentThread().getName();

        while(ticket > 0){
            ticket --;
            count ++;
            System.out.println(threadName+"：卖了一张票剩余---"+ticket);
            try {
                Thread.sleep(100);//阻塞100毫秒，不要该线程一下子就把ticket卖完
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName+":一共卖出了:"+count+"张票");


    }

}