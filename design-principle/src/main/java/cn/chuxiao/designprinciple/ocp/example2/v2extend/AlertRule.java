package cn.chuxiao.designprinciple.ocp.example2.v2extend;

//AlertRule 存储告警规则，可以自由设置
public interface AlertRule {
    AlertRule getMatchedRule(String name);

    int getMaxTps();

    int getMaxErrorCount();

    int getMaxTimeoutTps();
}
