package cn.chuxiao.designprinciple.ocp.example2.v1extend;

//新增功能
//一方面，对接口进行了修改，这就意味着调用这个接口的代码都要做相应的修改。
//另一方面，修改了check() 函数，相应的单元测试都需要修改
//是基于“修改”的方式来实现新功能的
public class Alert {

    private AlertRule alertRule;
    private Notification notification;


    public Alert(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    // 改动一：添加参数 timeoutCount
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount) {

        long tps = requestCount / durationOfSeconds;
        if (tps > alertRule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > alertRule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }

        //改动二：添加接口超时处理逻辑
        long timeoutTps = timeoutCount / durationOfSeconds;
        if (timeoutTps > alertRule.getMatchedRule(api).getMaxTimeoutTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
