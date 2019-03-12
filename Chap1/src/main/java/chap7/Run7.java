package chap7;

/**
 * @Author: ZST
 * @Date: 2019/3/12
 */
public class Run7 {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject object = new SynchronizedObject();
        MyThread7 thread7 = new MyThread7(object);
        thread7.start();
        Thread.sleep(50);
        thread7.stop();
        System.out.println(object.getName()+","+object.getPassWord());
    }
}
class SynchronizedObject {
    private String name = "a";
    private String passWord = "aa";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    synchronized public void prinString(String name,String passWord) {
        try {
            this.name = name;
            Thread.sleep(10000);
            this.passWord = passWord;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread7 extends Thread {
    private SynchronizedObject object;
    public MyThread7(SynchronizedObject object){
        this.object = object;
    }
    @Override
    public void run() {
        super.run();
        object.prinString("b","bb");
    }
}