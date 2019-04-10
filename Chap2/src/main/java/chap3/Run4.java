package chap3;

/**
 * @Author: ZST
 * @Date: 2019/4/9
 */
public class Run4 {
    public static void main(String[] args) {
        Print4[] print4s = new Print4[100];
        for (int i=0;i<100;i++) {
            print4s[i] = new Print4();
        }
        for (int i=0;i<100;i++) {
            print4s[i].start();
        }
    }
}

class Print4 extends Thread {

    volatile public static int count;

    synchronized static public void addAmount() {
        for (int i=1;i<100;i++) {
            count++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        addAmount();
    }
}