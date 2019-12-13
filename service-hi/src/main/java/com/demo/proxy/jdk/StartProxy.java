package com.demo.proxy.jdk;

import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @author suyon
 * @date 2019-12-12 16:54
 */
@Setter
public class StartProxy implements InvocationHandler {
    public Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("舞台方收费....");

        Object result = method.invoke(target, args);
        return result;
    }

    //生成代理类
    public Object createProxyObj(){
//        ClassLoader loader,
//        Class<?>[] interfaces,
//        InvocationHandler h
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );

    }
}
