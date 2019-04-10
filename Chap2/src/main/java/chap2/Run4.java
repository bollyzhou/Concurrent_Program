package chap2;

/**
 * @Author: ZST
 * @Date: 2019/3/13
 */
public class Run4 {
    public static void main(String[] args) {
        Task task = new Task();

        MyThead4 myThead4A = new MyThead4(task);
        myThead4A.setName("A");
        MyThead4 myThead4B = new MyThead4(task);
        myThead4B.setName("B");
        myThead4A.start();
        myThead4B.start();
    }
}
class Task {
    public void method() {
        for (int i=0;i<50;i++){
            System.out.println("nosynchronized thread name:" + Thread.currentThread().getName() + ", i = " + i);
        }
        synchronized (this) {
            for (int j=0;j<10;j++){
                System.out.println("synchronized thread name:" + Thread.currentThread().getName() + ", j = " + j);
            }
        }

    }
}

class MyThead4 extends Thread {
    private Task task;
    public MyThead4(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.method();
    }
}