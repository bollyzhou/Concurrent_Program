package chap2;

/**
 * @Author: ZST
 * @Date: 2019/3/18
 */
public class Run7 {
    public static void main(String[] args) {
        Service service = new Service();
        MyThread7A myThread7A = new MyThread7A(service);
        MyThread7B myThread7B = new MyThread7B(service);
        myThread7A.setName("A");
        myThread7B.setName("B");
        myThread7A.start();

        myThread7B.start();
    }
}
class Service {
    private String name;
    private String pasword;
    private String anyString = new String();

    public void setNameandPassword(String name,String pasword) {
        try {
            synchronized (anyString) {

                System.out.println("当前线程名字：" + Thread.currentThread().getName() + ",当前时间是："+System.currentTimeMillis() + ",开始");
                this.name = name;
                Thread.sleep(1000);
                this.pasword = pasword;
                System.out.println("当前线程名字：" + Thread.currentThread().getName() + ",当前时间是："+System.currentTimeMillis() + ",结束");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread7A extends Thread {
    private Service service;
    public MyThread7A(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.setNameandPassword("A","AA");

    }
}
class MyThread7B extends Thread {
    private Service service;
    public MyThread7B(Service service){
        this.service = service;
    }

    @Override
    public void run() {
        service.setNameandPassword("B","BB");

    }
}