package cn.chuxiao.designprinciple.lod.example1.v2;

//HtmlDownloader 类用来通过URL获取网页

public class HtmlDownloader {
    //通过构造函数或 IOC注入
    private NetworkTransporter transporter;

    public Html downloadHtml(String url) {
        HtmlRequest request = new HtmlRequest(url);
        byte[] rawHtml = transporter.send(request.getAddress(),request.getContent().getBytes());
        return new Html(rawHtml);
    }
}
