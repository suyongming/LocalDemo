package com.demo.main;

import com.demo.dao.PersonDao;
import com.demo.dao.impl.PersonImpl;
import com.demo.proxy.PersonProxy;

import java.lang.reflect.Proxy;

public class ProxyJDKMain {
    public static void main(String[] args){
        System.out.println("Proved.............");
        PersonImpl targetObject = new PersonImpl("Bob Liang");
        PersonProxy proxy = new PersonProxy(targetObject);
        //生成代理对象
        PersonDao object = (PersonDao) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), proxy);
        object.add();

        System.out.println("NO Proved.............");
        targetObject = new PersonImpl();
        proxy = new PersonProxy(targetObject);
        //生成代理对象
        object = (PersonDao)Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), proxy);
        object.add();
    }
}
