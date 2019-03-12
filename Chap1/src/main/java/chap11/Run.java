package chap11;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(100);
        System.out.println("我结束就不打印了");
    }
}
class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("i="+i);
            i++;
        }
    }
}