package com.demo.threadsym.test;

import com.demo.threadsym.test.entity.PersonT;
import com.demo.threadsym.test.entity.WC;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写多线程程序，模拟多个人排队拉屎的模拟。
 * 这个厕所每次只能通过一个人，每个人通过拉屎的时间为5秒，有10个人同时准备拉屎，
 * 显示每次拉屎人的姓名和顺序。
 * 要求:
 * 1.线程结束时  厕所里面没有人
 * 2.厕所有几泡屎
 * @author suyon
 * @date 2019-12-03 10:37
 */
public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        PersonT p1 = new PersonT("大虎");
        PersonT p2 = new PersonT("二狗");
        PersonT p3 = new PersonT("张三");
        PersonT p4 = new PersonT("李四");
        PersonT p5 = new PersonT("王五");

        new Thread(()->{
            try {
                p1.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                p2.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                p3.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                p4.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                p5.say();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



        Thread.sleep(50000);
        System.out.println("厕所还有"+WC.personCount+"个人没出来");
        System.out.println("一共有"+ WC.shits+"坨屎");

    }


}



