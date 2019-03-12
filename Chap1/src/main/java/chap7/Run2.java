package chap7;

/**
 * @Author: ZST
 * @Date: 2019/3/1
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1====="+Thread.interrupted());
        System.out.println("是否停止2====="+Thread.interrupted());
//        MyThread2 myThread = new MyThread2();
//        myThread.start();
//        System.out.println("===========start");
//        Thread.currentThread().interrupt();
//        myThread.interrupt();
//        System.out.println("myThread是否被打断？====="+ Thread.interrupted());
//        System.out.println("myThread是否被打断？====="+ Thread.interrupted());
//        System.out.println("===========end");
    }

}
class MyThread2 extends Thread {
    @Override
    public void run(){
        for(int i=0;i<50000;i++){
            System.out.println("i=" + i);
        }
    }
}