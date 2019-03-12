package chap9;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        long count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0;i<5000000;i++){
            /**
             * yield()方法、sleep()方法都不会释放锁资源。
             */
            Thread.yield();
            count = count+i;
        }
        System.out.println("count===="+count);
        long end = System.currentTimeMillis();
        System.out.println("耗时："+ (end-start));
    }
}