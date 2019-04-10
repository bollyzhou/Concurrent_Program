package chap3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ZST
 * @Date: 2019/4/10
 */
public class Run5 {
    public static void main(String[] args) {
        MyThread5 service = new MyThread5();
        Thread myThread1 = new Thread(service,"A");
        Thread myThread2 = new Thread(service,"B");
        Thread myThread3 = new Thread(service,"C");
        Thread myThread4 = new Thread(service,"D");
        Thread myThread5 = new Thread(service,"E");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
    }
}
class MyThread5 extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i=0;i<1000;i++) {
            count.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName() + "线程结果，count = " + count);
    }
}