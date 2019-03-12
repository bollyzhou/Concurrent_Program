package chap4;

/**
 * @Author: ZST
 * @Date: 2019/3/1
 */
public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("start====="+myThread.isAlive());
        myThread.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("end====="+myThread.isAlive());

    }
}
class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("run===="+this.isAlive());
    }
}