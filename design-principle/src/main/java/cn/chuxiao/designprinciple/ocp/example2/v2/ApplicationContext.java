package cn.chuxiao.designprinciple.ocp.example2.v2;

//ApplicationContext 是一个单例类，
// 负责Alert的创建、组装（alertRule和notification的依赖注入）、初始化（添加handlers）工作。
public class ApplicationContext {
    //饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    private ApplicationContext() {
        instance.initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public void initializeBeans() {
        //省略一些初始化代码
        alertRule = null;
        //省略一些初始化代码
        notification = null;
        //省略一些初始化代码
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }

    public Alert getAlert() {
        return alert;
    }
}

