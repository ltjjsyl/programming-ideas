package cn.chuxiao.designpattern.observer;

public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        //TODO: 获取通知消息，执行自己的逻辑
        System.out.println("ConcreteObserverTwo is notified, message : " + message);
    }
}
