package cn.chuxiao.designprinciple.lsp.example1;


import org.apache.http.client.HttpClient;


public class Transporter {

    private HttpClient httpClient;

    public Transporter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void sendRequest(Request request) {
        //...
    }
}
