package com.demo.reflect;

import com.demo.pojo.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
):
 */
public class MethodClass {

    public static void main(String[] args) throws Exception {

        Class clazz = Person.class;//获取person的class空间对象
        Person person = (Person)clazz.getDeclaredConstructor().newInstance();//映射person
        Method method = clazz.getDeclaredMethod("show4",int.class);//映射私有的方法,并给T类型的参数
        method.setAccessible(true);
        method.invoke(person,3);
    }
}
