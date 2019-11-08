package com.demo.threadsym.day01;

public class MyThreadDay01 extends Thread {
    /**
     * 1.0.0    可以看出每个线程都有一个属于自己的实例变量count，它们之间互不影响。我们再来看看另一种情况。
     */
//    private int count = 5;
//    public MyThread(String name) {
//        super();
//        this.setName(name);
//    }
//
//
//    @Override
//    public void run() {
//        super.run();
//        while (count > 0) {
//            count--;
//            System.out.println("由 " + MyThread.currentThread().getName()
//                    + " 计算，count=" + count);
//        }
//    }

    /**
     * 1.0.1
     * 取得原有count值
     * 计算i -1
     * 对i进行赋值
     * 所以多个线程同时访问时出现问题就是难以避免的了。
     */
//    private int count = 5;
//
//    @Override
//    public synchronized void run() {
//        super.run();
//        count--;
//        System.out.println("由 " + MyThread.currentThread().getName() + " 计算，count=" + count);
//    }

   /**
    * 1.0.2
    * 使用return停止线程
    * */

//   @Override
//    public void run(){
//       super.run();
//       int i = 0;
//       while(true){
//           i++;
//           if(this.isInterrupted()){
//               System.out.println(i+"ms...结束");
//               return;
//           }else{
//               System.out.println(i+"ms...");
//           }
//           try {
//               sleep(2000);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
//       }
//
//   }

    /**
     * 1.0.3
     * 线程优先级
     * */
//    @Override
//    public void run() {
//        System.out.println("MyThread1 run priority=" + this.getPriority());
//        MyThreadDay02 thread2 = new MyThreadDay02();
//        thread2.start();
//    }

    /**
     * 1.0.4
     * 守护线程
     * 例如1.
     *                 qq,飞讯等等聊天软件,主程序是非守护线程,而所有的聊天窗口是守护线程
     *                 ,当在聊天的过程中,直接关闭聊天应用程序时,聊天窗口也会随之关闭,但是不是
     *                 立即关闭,而是需要缓冲,等待接收到关闭命令后才会执行窗口关闭操作.
     *         例如2.
     *                 jvm中,gc线程是守护线程,作用就是当所有用户自定义线以及主线程执行完毕后,
     *                 gc线程才停止(再次必须要给你们验证一下,csdn中好多人都人为主线程也是守护线程,其实不是的)
     * */
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + (i));
                Thread.sleep(100);//守护线程不是立即停止,中间有个缓冲时间！
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
