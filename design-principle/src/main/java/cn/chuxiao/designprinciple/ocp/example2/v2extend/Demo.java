package cn.chuxiao.designprinciple.ocp.example2.v2extend;

public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ... 省略设置 apiStatInfo 数据值的代码

        // 改动四：设置 tiemoutCount 值
        apiStatInfo.setTimeoutCount(289);
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
