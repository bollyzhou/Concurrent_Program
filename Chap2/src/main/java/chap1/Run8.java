package chap1;

/**
 * @Author: ZST
 * @Date: 2019/3/13
 * synchronized 是不可以继承的。
 *  父类有同步方法，子类如果重写此同步方法，必须加synchronized 关键字修饰，才是同步方法，如果不加synchronized关键字则是异步方法
 */
public class Run8 {
    public static void main(String[] args) {
        ZI zi = new ZI();
        MyThread8A myThread8A = new MyThread8A(zi);
        MyThread8B myThread8B = new MyThread8B(zi);

        myThread8A.setName("A");
        myThread8B.setName("B");

        myThread8A.start();
        myThread8B.start();
    }
}
class FU {
    synchronized public void method(){
        try {
            System.out.println("thread name :"+Thread.currentThread().getName() + ",fu sleep beigin time: "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("thread name :"+Thread.currentThread().getName() + ",fu sleep end time: "+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ZI extends FU {
    @Override
    synchronized public void method() {
        try {
            System.out.println("thread name :"+Thread.currentThread().getName() + ",zi sleep beigin time: "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("thread name :"+Thread.currentThread().getName() + ",zi sleep end time: "+System.currentTimeMillis());
            super.method();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread8A extends Thread {
    private ZI zi;
    public MyThread8A(ZI zi){
        this.zi = zi;
    }

    @Override
    public void run() {
        zi.method();
    }
}
class MyThread8B extends Thread {
    private ZI zi;
    public MyThread8B(ZI zi){
        this.zi = zi;
    }

    @Override
    public void run() {
        zi.method();
    }
}