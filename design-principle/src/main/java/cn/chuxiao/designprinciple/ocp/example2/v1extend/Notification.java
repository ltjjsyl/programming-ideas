package cn.chuxiao.designprinciple.ocp.example2.v1extend;

//。Notification 是告警通知类，支持邮件、 短信、微信、手机等多种通知渠道
public interface Notification {

    void notify(NotificationEmergencyLevel level, String msg);
}
