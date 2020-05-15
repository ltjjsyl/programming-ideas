package cn.chuxiao.designprinciple.lod.example1.v1;

//HtmlDownloader 类用来通过URL获取网页

public class HtmlDownloader {
    //通过构造函数或 IOC注入
    private NetworkTransporter transporter;

    public Html downloadHtml(String url) {
        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
        return new Html(rawHtml);
    }
}
