package chaptwo;

/**
 * @Author: ZST
 * @Date: 2019/2/28
 */
public class ALogin extends Thread {

    @Override
    public void run(){
        LoginServlet.dopost("a","aa");
    }
}
