package chap2;

/**
 * @Author: ZST
 * @Date: 2019/4/1
 */
public class Run15 {
    public static void main(String[] args) {
        Outer15.Inner inner = new Outer15.Inner();
        Outer15.Inner2 inner2 = new Outer15.Inner2();
        MyThread15A myThread15A = new MyThread15A(inner,inner2);
        MyThread15B myThread15B = new MyThread15B(inner);
        MyThread15C myThread15C = new MyThread15C(inner2);

        myThread15A.setName("A");
        myThread15B.setName("B");
        myThread15C.setName("C");
        myThread15C.start();
        myThread15B.start();
        myThread15A.start();

    }
}

class Outer15 {
    static class Inner {
        public void a(Inner2 inner2){
            synchronized (inner2) {
                for (int i=0;i<100;i++) {
                    System.out.println("线程"+Thread.currentThread().getName() + ",i="+i);
                }
            }
        }

        public synchronized void b() {
            for (int i=0;i<100;i++) {
                System.out.println(Thread.currentThread().getName() + ",i="+i);
            }
        }
    }
    static class Inner2 {
        public synchronized void b() {
            for (int i=0;i<100;i++) {
                System.out.println(Thread.currentThread().getName() + ",i="+i);
            }
        }
    }

}

class MyThread15A extends Thread {
    private Outer15.Inner inner;
    private Outer15.Inner2 inner2;
    public MyThread15A(Outer15.Inner inner,Outer15.Inner2 inner2) {
        this.inner = inner;
        this.inner2 = inner2;
    }

    @Override
    public void run() {
        inner.a(inner2);
    }
}

class MyThread15B extends Thread {
    private Outer15.Inner inner;
    public MyThread15B(Outer15.Inner inner) {
        this.inner = inner;
    }

    @Override
    public void run() {
        inner.b();
    }
}
class MyThread15C extends Thread {
    private Outer15.Inner2 inner2;
    public MyThread15C(Outer15.Inner2 inner2) {
        this.inner2 = inner2;
    }

    @Override
    public void run() {
        inner2.b();
    }
}