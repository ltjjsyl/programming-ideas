package cn.chuxiao.designprinciple.dip.di;

// 短信发送类
public class SmsSender implements MessageSender {

    @Override
    public void send(String cellphone, String message) {
        //....
    }
}