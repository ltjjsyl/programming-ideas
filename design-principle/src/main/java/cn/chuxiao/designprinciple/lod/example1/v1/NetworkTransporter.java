package cn.chuxiao.designprinciple.lod.example1.v1;

//NetworkTransporter 类负责底层网络通信，根据请求获取数据
// 作为一个底层网络通信类，希望它的功能尽可能通用，而不只是服务于下载HTML，
// 所以，不应该直接依赖太具体的发送对象HtmlRequest。
// 从这一点上讲，NetworkTransporter类的设计违背迪米特法则，依赖了不该有直接依赖关系的HtmlRequest类
public class NetworkTransporter {

    //...

    public Byte[] send(HtmlRequest htmlRequest) {
        return null;
    }
}
