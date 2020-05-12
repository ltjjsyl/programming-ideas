package cn.chuxiao.designprinciple.dip.ioc;

//所有的流程都由程序员来控制
public class UserServiceTestV1 {

    public static boolean doTest() {
        //...
        return false;
    }

    public static void main(String[] args) {
        if (doTest()) {
            System.out.println("test success");
        } else {
            System.out.println("test fail");
        }
    }
}
