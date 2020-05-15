package cn.chuxiao.designprinciple.lod.example1.v2;

//Document 表示网页文档，后续的网页内容抽取、分词、索引都是 以此为处理对象
public class Document {

    private Html html;
    private String url;

    public Document(String url, Html html) {
        this.url = url;
        this.html = html;
    }

    //...
}
