package chap1;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 * synchronized 是获得的对象锁
 */
public class Run4 {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        MyTheadA myTheadA = new MyTheadA(object);
        MyTheadB myTheadB = new MyTheadB(object);
        myTheadA.setName("a");
        myTheadB.setName("b");
        myTheadA.start();
        myTheadB.start();
    }
}
class MyObject {
    synchronized public void method() throws InterruptedException {
        System.out.println("begin method threadName :"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("end");
    }
}

class MyTheadA extends Thread {
    private MyObject object;
    public MyTheadA(MyObject object){
        this.object = object;
    }

    @Override
    public void run() {
        try {
            object.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyTheadB extends Thread {
    private MyObject object;
    public MyTheadB(MyObject object){
        this.object = object;
    }

    @Override
    public void run() {
        try {
            object.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}