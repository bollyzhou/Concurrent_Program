package chap2;

/**
 * @Author: ZST
 * @Date: 2019/3/1
 */
public class MyThread extends Thread {
    private int count = 5;

//    public MyThread(String name){
//        super();
//        this.setName(name);
//    }

    @Override
    synchronized public void run(){
        super.run();
//        while(count>0){ //测试共享数据的时候不要用循环，如果使用就会变成单线程在执行。
            count--;
            System.out.println("由" + Thread.currentThread().getName() + "计算，count = " + count);
//        }
    }
}
