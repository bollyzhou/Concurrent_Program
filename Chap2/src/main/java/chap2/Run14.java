package chap2;

/**
 * @Author: ZST
 * @Date: 2019/4/1
 */
public class Run14 {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        MyThread14A myThread14A = new MyThread14A(inner);
        MyThread14B myThread14B = new MyThread14B(inner);
        myThread14A.setName("A");
        myThread14B.setName("B");
        myThread14A.start();
        myThread14B.start();

    }
}
class Outer {
    static class Inner {
        public void a(){
            synchronized ("其他的锁") {
                for (int i=0;i<1000;i++) {
                    System.out.println("线程"+Thread.currentThread().getName() + ",i="+i);
                }
            }
        }

        public synchronized void b() {
            for (int i=0;i<1000;i++) {
                System.out.println("Thread.currentThread().getName():"+Thread.currentThread().getName() + ",i="+i);
            }
        }
    }

}

class MyThread14A extends Thread {
    private Outer.Inner inner;
    public MyThread14A(Outer.Inner inner) {
        this.inner = inner;
    }

    @Override
    public void run() {
        inner.a();
    }
}

class MyThread14B extends Thread {
    private Outer.Inner inner;
    public MyThread14B(Outer.Inner inner) {
        this.inner = inner;
    }

    @Override
    public void run() {
        inner.b();
    }
}