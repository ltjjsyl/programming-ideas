package cn.chuxiao.designprinciple.dip.ioc;

// 典型的通过框架来实现“控制反转”的例子。
// 框架提供了一个可扩展的代码骨架，用来组装对象、管理整个执行流程。
// 程序员利用框架进行开发的时候，只需要往预留的扩展点上，添加跟自己业务相关的代码，
// 就可以利用框架来驱动整个程序流程的执行,流程的控制权从程序员“反转”到了框架
public class UserServiceTestV2 extends TestCase {

    public boolean doTest() {
        //...
        return false;
    }
}
