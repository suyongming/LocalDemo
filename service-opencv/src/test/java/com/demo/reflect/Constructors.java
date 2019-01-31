package com.demo.reflect;

import com.demo.pojo.Person;

import java.lang.reflect.Constructor;

/*
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *
 * 1.获取构造方法：
 * 		1).批量的方法：
 * 			public Constructor[] getConstructors()：所有"公有的"构造方法
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

 * 		2).获取单个的方法，并调用：
 * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 * 			调用构造方法：
 * 			Constructor-->newInstance(Object... initargs)
 */
public class Constructors {
    public static void main(String[] args) throws Exception {
        Class clazzPerson = Class.forName("com.demo.pojo.Person");

        Constructor constructor =  clazzPerson.getConstructor(char.class); //获取对应的构造方法
        constructor.setAccessible(true);//暴力访问忽略访问修饰符

        Person person = (Person)constructor.newInstance('男');
        System.out.println(person.getName());

    }
}
