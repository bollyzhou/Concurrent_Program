package chap3;

/**
 * @Author: ZST
 * @Date: 2019/4/9
 */
public class Run2 {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(print).start();

        System.out.println("停止打印："+Thread.currentThread().getName());
        print.setFlag(false);
    }
}

class Print implements Runnable {

    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void method(){
        while (flag) {
            System.out.println("aaa");
        }
    }

    @Override
    public void run() {
        method();
    }
}