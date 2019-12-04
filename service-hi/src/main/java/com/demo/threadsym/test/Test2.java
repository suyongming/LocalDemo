package com.demo.threadsym.test;

/**
 *  编写两个线程,一个线程打印1-52的整数，另一个线程打印字母A-Z。打印顺序为12A34B56C….5152Z。
 *  即按照整数和字母的顺序从小到大打印，并且每打印两个整数后，打印一个字母，交替循环打印，
 *  直到打印到整数52和字母Z结束。
 * @author suyon
 * @date 2019-12-02 14:08
 */
public class Test2 {
    public static void main(String[] args){
        new Thread(new NumberPrinter(),"p1").start();
        new Thread(new NumberPrinter(),"p2").start();


    }
}

class NumberPrinter implements Runnable {
    private Printer p = new Printer();

    @Override
    public void run() {
        try {
            while (Printer.index < 52 || Printer.c <= 'z') {
//                Thread.sleep(50);

                p.print();
                Printer.index ++ ;

            }
        }catch(Exception e){

        }

    }
}

class Printer{
    public volatile static int index = 1;
    public volatile static char c = 'a';

    public void print(){
        if(index % 3 != 0 && index < 52){
            System.out.println(Thread.currentThread().getName()+":"+index);
        }else{
            if(index <= 52){
                System.out.println(Thread.currentThread().getName()+":"+index);
            }
            System.out.println(Thread.currentThread().getName()+":"+c);
            c ++;
        }
    }



}
