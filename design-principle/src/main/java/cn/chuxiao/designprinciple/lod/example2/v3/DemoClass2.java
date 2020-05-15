package cn.chuxiao.designprinciple.lod.example2.v3;

//通过接口隔离
public class DemoClass2 {
    private Deserializable deserializer;

    public DemoClass2(Deserializable deserializer) {
        this.deserializer = deserializer;
    }
}
