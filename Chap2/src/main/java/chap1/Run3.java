package chap1;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run3 {
    public static void main(String[] args) {
        HasSelfPrivateNum a = new HasSelfPrivateNum();
//        HasSelfPrivateNum b = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(a);
        ThreadB threadB = new ThreadB(a);
        threadA.start();
        threadB.start();

    }
}

class HasSelfPrivateNum {
    private int num = 0;
    synchronized public void addI(String userName) {
        try {
        if ("a".equals(userName)){
            num = 100;
            System.out.println("a set over!");
                Thread.sleep(2000);
        }else {
            num = 200;
            System.out.println("b set over!");
        }
        System.out.println(userName + "  num = " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadA extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;
    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        super.run();
        hasSelfPrivateNum.addI("a");
    }
}

class ThreadB extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;
    public ThreadB(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        super.run();
        hasSelfPrivateNum.addI("b");
    }
}