package com.demo.threadsym;

/**
 * 指令重排序
 *
 * @author suyon
 * @date 2019-11-22 16:59
 * <p>
 * 操作1	操作2	操作3	操作4	结果
 * a=1	    x=b	    b=1	    y=a	    (0,1)
 * a=1	    b=1	    x=b	    y=a	    (1,1)
 * a=1	    b=1	    y=a	    x=b	    (1,1)
 * b=1	    y=a	    a=1	    x=b	    (1,0)
 * b=1	    a=1	    y=a	    x=b	    (1,1)
 * b=1	    a=1	    x=b	    y=a	    (1,1)
 */
public class PossibleReordering {
    private static int a;
    private static int b;
    private static int x;
    private static int y;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            a = 1;
            x = b;
        });
        Thread threadB = new Thread(() -> {
            b = 1;
            y = a;
        });
        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
            System.out.printf("(%d,%d,%d,%d)", a, b, x, y);
            System.out.println();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
