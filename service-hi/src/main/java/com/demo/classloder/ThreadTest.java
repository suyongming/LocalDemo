package com.demo.classloder;

public class ThreadTest implements Runnable{

    private static final String CLASSNAME = "ThreadTest";
    @Override
    public void run() {
//        ClassLoader thisClassLoad = this.getClass().getClassLoader();
        System.out.println(CLASSNAME);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        对于WEB APP线程，它的contextClassLoader是WebAppClassLoader
//        对于Tomcat Server线程，它的contextClassLoader是CatalinaClassLoader
        Thread.currentThread().setContextClassLoader(Person.class.getClassLoader());
        //获取当前线程调用者的 ClassLoad
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //ClassLoad这时已经在JVM中加载过了
        Class<ThreadTest> cl = (Class<ThreadTest>)classLoader.loadClass("com.demo.classloder.ThreadTest");
        ThreadTest t1 = cl.newInstance();
        t1.run();


    }

}
