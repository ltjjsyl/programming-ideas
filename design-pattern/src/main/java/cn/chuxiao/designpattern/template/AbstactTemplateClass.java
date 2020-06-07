package cn.chuxiao.designpattern.template;

public abstract class AbstactTemplateClass {

    public final void templateMethod() {
        //...
        method1();
        //...
        method2();
    }

    //也可以提供默认实现
    protected abstract void method1();

    protected abstract void method2();
}
