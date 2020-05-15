package cn.chuxiao.designprinciple.lod.example1.v1;

import cn.chuxiao.designprinciple.lod.example1.v2.Html;
import cn.chuxiao.designprinciple.lod.example1.v2.HtmlDownloader;

//Document 表示网页文档，后续的网页内容抽取、分词、索引都是以此为处理对象
//。这个类的问题比较多，主要有三点。
// 第一，构造函数中 的 downloader.downloadHtml() 逻辑复杂，耗时长，
// 不应该放到构造函数中，会影响代码的可测试性。
// 第二，HtmlDownloader对象在构造函数中通过new来创建，违反了基于接口而非实现编程的设计思想，
// 也会影响到代码的可测试性。
// 第三，从业务含义上来讲，Document网页文档没必要依赖HtmlDownloader类，违背了迪米特法则
public class Document {
    private Html html;
    private String url;

    public Document(String url) {
        this.url = url;
        cn.chuxiao.designprinciple.lod.example1.v2.HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }

    //...
}
