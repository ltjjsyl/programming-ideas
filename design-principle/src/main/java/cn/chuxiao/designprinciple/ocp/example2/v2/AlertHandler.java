package cn.chuxiao.designprinciple.ocp.example2.v2;

//引入handler的概念，将if判断逻辑分散在各个handler中
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {

        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}
