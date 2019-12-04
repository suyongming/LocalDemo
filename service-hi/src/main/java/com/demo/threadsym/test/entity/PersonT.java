package com.demo.threadsym.test.entity;

import lombok.Data;

/**
 * @author suyon
 * @date 2019-12-04 10:04
 */
@Data
public class PersonT {

    private String name;

    public PersonT(String name){
        this.name = name;
    }

    //speak
    //say
    public void say() throws InterruptedException {
        while(WC.personCount > 0){
            //自旋5秒再重试
            System.out.println(name+":\"厕所里有"+WC.personCount+"个人锁门了,2秒后再试试\"。");

            Thread.sleep(2000);
        }

        if(WC.personCount == 0){
            System.out.println(name + ":我进去了,把门锁上了");
            WC.personCount ++;

            Thread.sleep(8000);

            System.out.println(name + "里面拉了一拖Shit，用了8秒,走出厕所");
            WC.personCount --;
            WC.shits ++;
        }

    }
}

