package cn.chuxiao.designpattern.proxy.dynamic;

/**
 * 也可以通过IHelloWorld实现
 */
public class StaticHelloWorldProxy extends HelloWorld {

    private HelloWorld hw;

    public StaticHelloWorldProxy(HelloWorld hw) {
        this.hw = hw;
    }

    @Override
    public void syaHello() {
        Logger.startLog();
        hw.syaHello();
        Logger.endLog();
    }
}
