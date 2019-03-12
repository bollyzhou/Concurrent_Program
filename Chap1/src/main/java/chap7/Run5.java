package chap7;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run5 {

    public static void main(String[] args) {

        try {
            MyThread5 myThread5 = new MyThread5();
            myThread5.start();
            Thread.sleep(500);
            myThread5.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread5 extends Thread {
    private int i=0;
    @Override
    public void run() {
        super.run();

        try {
            while (true) {
                System.out.println("i= " + i++);
                sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}