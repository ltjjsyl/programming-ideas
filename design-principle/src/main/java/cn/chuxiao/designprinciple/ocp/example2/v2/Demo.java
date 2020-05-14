package cn.chuxiao.designprinciple.ocp.example2.v2;

public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ... 省略设置 apiStatInfo 数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
