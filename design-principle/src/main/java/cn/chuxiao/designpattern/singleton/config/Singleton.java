package cn.chuxiao.designpattern.singleton.config;

/**
 * 通过全局变量解决单例类的构造参数问题
 */
public class Singleton {

    private static Singleton instance = null;

    private final int paramA;
    private final int paramB;

    private Singleton() {
        paramA = Config.PARAM_A;
        paramB = Config.PARAM_B;
    }

    public static synchronized Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }

        return instance;
    }
}
