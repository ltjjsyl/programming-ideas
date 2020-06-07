package cn.chuxiao.designpattern.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * 同步
 * */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}
