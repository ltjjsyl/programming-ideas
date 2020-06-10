package cn.chuxiao.designpattern.proxy.dynamic;

public class Main {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        StaticHelloWorldProxy staticHelloWorldProxy = new StaticHelloWorldProxy(helloWorld);
        staticHelloWorldProxy.syaHello();

        IHelloWorld prxoy = (IHelloWorld) DynamicHelloWorldProxy.createProxy(helloWorld);
        prxoy.syaHello();
    }
}
