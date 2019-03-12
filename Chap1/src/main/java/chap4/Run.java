package chap4;

/**
 * @Author: ZST
 * @Date: 2019/3/1
 */
public class Run {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread a = new Thread(countOperate, "A");
        System.out.println("main  start a.isAlive():" + a.isAlive());
        a.start();
        System.out.println("main   end  a.isAlive():" + a.isAlive());
    }
}
class CountOperate extends Thread {
    public CountOperate(){
        System.out.println("CountOperate  start");
        System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive():" + Thread.currentThread().isAlive());
        System.out.println("this.getName():" + this.getName());
        System.out.println("this.isAlive():" + this.isAlive());
        System.out.println("CountOperate   end");
    }

    @Override
    public void run(){
        System.out.println("run  start");
        System.out.println("Thread.currentThread().getName():" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive():" + Thread.currentThread().isAlive());
        System.out.println("this.getName():" + this.getName());
        System.out.println("this.isAlive():" + this.isAlive());
        System.out.println("run   end");
    }
}