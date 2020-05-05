package cn.chuxiao.designprinciple.lsp.example1;


public class Demo {

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.demoFunction(new Transporter(null));
        //SecurityTransporterV1符合里氏替换原则
        demo.demoFunction(new SecurityTransporterV1(null, "", ""));

        //SecurityTransporterV2不符合里氏替换原则，父类没有抛出异常
        //实际破坏了通用的抽象逻辑
        demo.demoFunction(new SecurityTransporterV2(null, "", ""));

    }

    public void demoFunction(Transporter transporter) {

        Request request = new Request();
        //... 省略设置 request 中数据值的代码...
        transporter.sendRequest(request);
        //... 省略其他逻辑...
    }
}
