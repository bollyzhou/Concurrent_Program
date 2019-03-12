package chap7;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run8 {

    public static void main(String[] args) {

        try {
            MyThread8 myThread8 = new MyThread8();
            myThread8.start();
            Thread.sleep(50);
            myThread8.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread8 extends Thread {
    private int i=0;
    @Override
    public void run() {
        super.run();
        while (true) {
            System.out.println("i= " + i++);
            if (this.isInterrupted()) {
                System.out.println("结束了");
                return;
            }
        }

    }
}