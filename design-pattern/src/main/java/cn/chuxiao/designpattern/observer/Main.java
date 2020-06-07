package cn.chuxiao.designpattern.observer;

public class Main {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());

        subject.notifyObserver(new Message());
    }
}
