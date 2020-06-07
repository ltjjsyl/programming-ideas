package cn.chuxiao.designpattern.observer;

public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        //TODO: 获取通知消息，执行自己的逻辑
        System.out.println("ConcreteObserverOne is notified, message : " + message);
    }
}
