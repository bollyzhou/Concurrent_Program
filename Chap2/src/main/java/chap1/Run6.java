package chap1;

/**
 * @Author: ZST
 * @Date: 2019/3/13
 * synchronized 可以重入，就是自己有多个同步方法是，方法间是可以相互调用同步方法的，在同一个对象锁下就可以。父类和子类之间也可以重入。
 */
public class Run6 {
    public static void main(String[] args) {
        new Thread(()->{
            Zi zi = new Zi();
            zi.zimethod();
        }).start();
    }
}
class Fu {
    public int i =10;
    synchronized public void fumethod(){
        try {
            i--;
            System.out.println("fu print i = " + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Zi extends Fu {
    synchronized public void zimethod(){
        try {
            while (i>0){
                i--;
                System.out.println("zi print i = " + i);
                Thread.sleep(100);
                this.fumethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}