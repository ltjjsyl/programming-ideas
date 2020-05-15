package cn.chuxiao.designprinciple.lod.example2.v2;

// 将Serialization类拆分为两个更小粒度的类，
// 一个只负责序列化（Serializer 类），一个只负责反序列化（Deserializer 类）
// 却违背了高内聚的设计思想
// 高内聚要求相近的功能要放到同一个类中，这样可以方便功能修改的时候，修改的地方不至于过于分散。
public class Serializer {
    public String serialize(Object object) {
        String serializedResult = "";
        //...
        return serializedResult;
    }
}
