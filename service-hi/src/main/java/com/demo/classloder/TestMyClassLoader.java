package com.demo.classloder;

public class TestMyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader mcl = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());
         Class<?> c1 = Class.forName("com.demo.classloder.Person", true, mcl);
         Object obj = c1.newInstance();
         System.out.println(obj);
         System.out.println(obj.getClass().getClassLoader());

    }
}
