package chaptwo;

/**
 * @Author: ZST
 * @Date: 2019/2/28
 */
public class Run {
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        BLogin bLogin = new BLogin();
        aLogin.start();
        bLogin.start();
    }
}
