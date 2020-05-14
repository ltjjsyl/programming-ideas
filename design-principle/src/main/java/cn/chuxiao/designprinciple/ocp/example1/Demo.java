package cn.chuxiao.designprinciple.ocp.example1;
// 通过Kafka来发送异步消息。对于这样一个功能的开发，要学会将其抽象成一组跟具体消息队列（Kafka）无关的异步消息接口。
// 所有上层系统都依赖这组抽象的接口编程，并且通过依赖注入的方式来调用。
// 当要替换新的消息队列的时候，比如将Kafka替换成RocketMQ，可以很方便地拔掉老的消息队列实现，插入新的消息队列实现
public class Demo {

    private MessageQueue messageQueue;// 基于接口而非实现编程

    // 依赖注入
    public Demo(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    //messageFormatter:多态，依赖注入
    public void sendNotification(Notification notification, MessageFormatter messageFormatter) {
    }
}
