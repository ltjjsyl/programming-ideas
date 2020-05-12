package cn.chuxiao.designprinciple.dip.di;

//使用方式
public class Main {

    public static void main(String[] args) {

        NotificationWithoutDI notificationWithoutDI = new NotificationWithoutDI();
        notificationWithoutDI.sendMessage("", "");

        MessageSender sender1 = new SmsSender();
        MessageSender sender2 = new InboxSender();//DI Framework可以做这部分工作
        NotificationWithDI notificationWithDI = new NotificationWithDI(sender1);//// 依赖注入
        notificationWithDI.sendMessage("", "");
    }
}
