package com.demo.proxy;

import com.demo.dao.impl.PersonImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 代理类
 * */
public class PersonProxy implements InvocationHandler {
    private Object targetObject;

    public  PersonProxy(Object targetObject)
    {
        this.targetObject = targetObject;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PersonImpl personImpl = (PersonImpl) targetObject;
        String userName = personImpl.getUserName();
        Object result = null;

        //权限判断
        if(userName != null && !"".equals(userName))
        {
            //代理方法调用 目标对象，参数
            result = method.invoke(targetObject, args);
        }

        return result;
    }
}
