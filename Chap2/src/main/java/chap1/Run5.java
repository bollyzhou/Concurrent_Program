package chap1;

/**
 * @Author: ZST
 * @Date: 2019/3/13
 *
 * 共享的数据，非同步的情况下，并发的时候会出现赃读
 */
public class Run5 {
    public static void main(String[] args) throws InterruptedException {
        PublicValue publicValue = new PublicValue();
        MyThread5 myThread5 = new MyThread5(publicValue);
        myThread5.start();
        Thread.sleep(200);
        publicValue.getValue();
    }
}
class PublicValue {
    private String name = "A";
    private String password = "AA";

    synchronized public void setValue(String name, String password) {
        try {
            this.name = name;
            Thread.sleep(1000);
            this.password = password;
            System.out.println("threadName =="+Thread.currentThread().getName() + ",name = " + this.name + ", password = " + this.password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue(){
        System.out.println("threadName =="+Thread.currentThread().getName() + ",name = " + this.name + ", password = " + this.password);
    }
}

class MyThread5 extends Thread {
    private PublicValue publicValue;
    public MyThread5(PublicValue publicValue) {
        this.publicValue = publicValue;
    }

    @Override
    public void run() {
        publicValue.setValue("b","bb");
    }
}
