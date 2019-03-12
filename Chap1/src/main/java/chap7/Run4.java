package chap7;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run4 {
    public static void main(String[] args) {
        try {
            System.out.println("begin");
            MyThread4 myThread4 = new MyThread4();
            myThread4.start();
            Thread.sleep(20);
            myThread4.interrupt();
            System.out.println("end");
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
class MyThread4 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i=0;i<500000;i++){
                System.out.println("i="+ i);
            }
            System.out.println("run begin");
            System.out.println("isInterrupted==="+this.isInterrupted());
            /**
             * 线程被中断，则线程中的sleep方法将不被执行，或者在执行中的sleep方法也会被打断。
             */
            sleep(10);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("再沉睡中被终止=="+this.isInterrupted());
            e.printStackTrace();
        }
    }
}