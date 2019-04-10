package chap2;

/**
 * @Author: ZST
 * @Date: 2019/3/30
 */
public class Run13 {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setName("zhangsan");
        publicClass.setSex("man");
        System.out.println(publicClass.getName()+","+publicClass.getSex());
        PublicClass.PrivateClass privateClass = new PublicClass.PrivateClass();
        privateClass.setAddress("Beijing");
        privateClass.setAge("10");
        System.out.println(privateClass.getAddress()+","+privateClass.getAge());
    }
}
class PublicClass {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    static class PrivateClass {
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}