package com.demo.reflect;

import com.demo.pojo.Person;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 * 通过反射越过泛型检查
 *
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        ArrayList<String> list = new ArrayList<String>();
        list.add("aa");


        Class clazzList = list.getClass();

        Method method = clazzList.getMethod("add",Object.class);
        method.invoke(list,100);

        for(Object element : list){
            System.out.println(element.getClass());
        }
    }
}
