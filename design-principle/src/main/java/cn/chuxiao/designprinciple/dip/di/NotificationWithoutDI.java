package cn.chuxiao.designprinciple.dip.di;

public class NotificationWithoutDI {

    private MessageSender messageSender;

    public NotificationWithoutDI() {
        this.messageSender = new SmsSender(); // 此处有点像 hardcode
    }

    public void sendMessage(String cellphone, String message) {
        //... 省略校验逻辑等...
        this.messageSender.send(cellphone, message);
    }
}
