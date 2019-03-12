package chap2;

/**
 * @Author: ZST
 * @Date: 2019/3/1
 */
public class MyThreadTest1 {

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread a = new Thread(myThread1, "A");
        a.start();
    }

}
class MyThread1 extends Thread {
    public MyThread1(){
        System.out.println("---MyThread1 begin---");
        System.out.println("Thread.currentThread.getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println(Thread.currentThread()==this);
        System.out.println("---MyThread1 begin---");
    }

    @Override
    public void run(){
        System.out.println("---run begin---");
        System.out.println("Thread.currentThread.getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println(Thread.currentThread()==this);
        System.out.println("---run end ---");
    }

}