package cn.chuxiao.designprinciple.dip.di;
// 依赖注入的实现方式
public class NotificationWithDI {

    private MessageSender messageSender;

    // 通过构造函数将 messageSender 传递进来
    public NotificationWithDI(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message) {
        this.messageSender.send(cellphone, message);
    }


}
