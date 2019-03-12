package chap7;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            MyThread3 myThread = new MyThread3();
            myThread.start();
            Thread.sleep(10);
            myThread.interrupt();

            System.out.println();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }

    }

}

class MyThread3 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for(int i=0;i<50000;i++){
                if (this.isInterrupted()){
                    System.out.println("线程中断。。。。结束");
                    throw new InterruptedException();
                }
                System.out.println("i="+i);
            }
            System.out.println("for下面，继续执行");

        } catch (InterruptedException e) {
            System.out.println("线程。。catch");
            e.printStackTrace();
        }

    }
}