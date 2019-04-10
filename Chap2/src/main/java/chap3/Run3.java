package chap3;

/**
 * @Author: ZST
 * @Date: 2019/4/9
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            Print3 print3 = new Print3();
            print3.start();
            Thread.sleep(1000);
            print3.setFlag(false);
            System.out.println("停止打印："+Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Print3 extends Thread {

    volatile private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("进入 run");
        while(flag == true){

        }
        System.out.println("结束 run");
    }
}