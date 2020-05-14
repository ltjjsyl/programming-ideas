package cn.chuxiao.designprinciple.ocp.example2.v1;

public class Alert {

    private AlertRule alertRule;
    private Notification notification;


    public Alert(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {


        long tps = requestCount / durationOfSeconds;
        if (tps > alertRule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > alertRule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }

    }
}
