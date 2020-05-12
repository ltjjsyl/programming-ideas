package cn.chuxiao.designprinciple.dip.ioc;

//简化版本的测试框架引入到工程中之后，只需要在框架预留的扩展点:doTest
public abstract class TestCase {

    public void run() {
        if (doTest()) {
            System.out.println("test success");
        } else {
            System.out.println("test fail");
        }
    }

    public abstract boolean doTest();
}
