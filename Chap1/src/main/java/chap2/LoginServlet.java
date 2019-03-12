package chap2;

/**
 * @Author: ZST
 * @Date: 2019/2/28
 */
public class LoginServlet {
    private static String useNameRef;
    private static String passWordRef;

    synchronized public static void dopost(String useName, String passWord){
        try {
            useNameRef = useName;
            if(useName.equals("a")){
                Thread.sleep(5000);
            }
            passWordRef = passWord;
            System.out.println("userName:" + useNameRef + ",passWord:" + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}