package cn.chuxiao.designprinciple.lod.example2.v1;

// 有些类只用到了序列化操作，而另一些类只用到反序列化操作。
// 那基于迪米特法则后半部分“有依赖关系的类之间，尽量只依赖必要的接口”，
// 只用到序列化操作的那部分类不应该依赖反序列化接口。同理，只用到反序列化操作的那部分类不应该依赖序列化接口
public class Serialization {
    public String serialize(Object object) {
        String serializedResult = "";
        //...
        return serializedResult;
    }

    public Object deserialize(String str) {
        return null;
    }
}
