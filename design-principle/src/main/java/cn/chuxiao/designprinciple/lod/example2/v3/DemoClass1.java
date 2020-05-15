package cn.chuxiao.designprinciple.lod.example2.v3;

//通过接口隔离
//传入包含序列化和反序列化的 Serialization实现类，
// 但是，依赖的 Serializable接口只包含序列化操作，
// DemoClass1无法使用Serialization类中的反序列化接口，对反序列化操作无感知，
// 符合了迪米特法则后半部分所说的“依赖有限接口”的要求。

public class DemoClass1 {
    private Serializable serializer;

    public DemoClass1(Serializable serializer) {
        this.serializer = serializer;
    }

    //...
}
