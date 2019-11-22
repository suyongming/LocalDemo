package com.demo.reflect;


/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */

import com.demo.pojo.Person;

import java.lang.reflect.Field;


/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */
public class Fields {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.demo.pojo.Person");
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);

        Person person = (Person)clazz.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();


        field.set(person,"张啸楠");
        field = clazz.getDeclaredField("sex");
        field.setAccessible(true);
        field.set(person,"女");
        System.out.println("验证:" + person.toString());

    }
}
