package com.demo.threadsym.day02.脏读;

public class ThreadA2 extends Thread {

    private PublicVar publicVar;

    public ThreadA2(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override
    public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}