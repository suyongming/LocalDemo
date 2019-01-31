package com.demo.reflect;

import com.demo.pojo.Person;

public class ReflexTest {
    public static void main(String[] args){
        //第一种方式获取Class对象
        Person per1 = new Person();//这一new 产生一个Student对象，一个Class对象。
        Class stuClass = per1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class per2 = Person.class;
        System.out.println(stuClass == per2);//判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //第三种方式获取Class对象
        try {
            Class per3 = Class.forName("com.demo.Person");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(per3 == per2);//判断三种方式是否获取的是同一个Class对象
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void printClassName(Object obj) {
        System.out.println("The class of " + obj +
                " is " + obj.getClass().getName());
    }

}
