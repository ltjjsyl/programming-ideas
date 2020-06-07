package cn.chuxiao.designpattern.observer.asyn.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * EventBus 实现的是阻塞同步的观察者模式
 * <p>
 * MoreExecutors.directExecutor()是Google Guava提供的工具类，看似是多线程，实际上是单线程。
 * 之所以要这么实现，主要还是为了跟AsyncEventBus统一代码逻辑，做到代码复用
 */
public class EventBus {

    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
