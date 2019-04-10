package chap2;

/**
 * @Author: ZST
 * @Date: 2019/4/9
 *  多个线程在同时获取一把锁的时候，当一个线程获取了锁，在执行过程中将这个锁的值修改，或者将锁的内部属性修改，其他线程都要等待同步执行。
 */
public class Run16 {
    public static void main(String[] args) throws InterruptedException {
        Service16 service16 = new Service16();
        MyThead16A myThead16A = new MyThead16A(service16);
        myThead16A.setName("A");
        MyThead16B myThead16B = new MyThead16B(service16);
        myThead16B.setName("B");
        MyThead16C myThead16C = new MyThead16C(service16);
        myThead16C.setName("C");
        myThead16A.start();
//        Thread.sleep(100);
        myThead16B.start();
        myThead16C.start();

    }
}

class Service16 {
    private String lock = "123";
    public void method(){
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "线程，start,当前时间：" + System.currentTimeMillis());
                lock = "234";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "线程，end,当前时间：" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThead16A extends Thread {
    private Service16 service16;
    public MyThead16A(Service16 service16){
        this.service16 = service16;
    }
    @Override
    public void run() {
        super.run();
        service16.method();
    }
}
class MyThead16B extends Thread {
    private Service16 service16;
    public MyThead16B(Service16 service16){
        this.service16 = service16;
    }
    @Override
    public void run() {
        super.run();
        service16.method();
    }
}

class MyThead16C extends Thread {
    private Service16 service16;
    public MyThead16C(Service16 service16){
        this.service16 = service16;
    }
    @Override
    public void run() {
        super.run();
        service16.method();
    }
}