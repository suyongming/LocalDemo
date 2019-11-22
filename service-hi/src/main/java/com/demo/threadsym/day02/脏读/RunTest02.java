package com.demo.threadsym.day02.脏读;


import com.demo.threadsym.day02.脏读.PublicVar;
import com.demo.threadsym.day02.脏读.ThreadA2;

public class RunTest02 {

    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadA2 thread = new ThreadA2(publicVarRef);
            thread.start();

            Thread.sleep(200);//打印结果受此值大小影响

            publicVarRef.getValue();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
