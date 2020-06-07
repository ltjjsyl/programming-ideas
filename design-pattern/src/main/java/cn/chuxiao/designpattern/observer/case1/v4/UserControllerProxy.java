package cn.chuxiao.designpattern.observer.case1.v4;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * v3 UserController还是耦合了很多 跟观察者模式相关的非业务代码，比如创建线程池、注册 Observer。
 * 为了让 UserController 更加聚焦在业务功能上，创建代理类重构
 * <p>
 * 代理模式，使用一个代理类专门来处理EventBus相关逻辑。作用：
 * 1.将业务与非业务逻辑分离
 * 2.后续替换EventBus实现方式直接改写代理类，满足拓展需求
 */
public class UserControllerProxy extends UserController {

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    private EventBus eventBus;

    public UserControllerProxy() {
        //eventBus = new EventBus();//同步阻塞模式
        //异步非阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> regObservers) {
        for (Object observer : regObservers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {

        Long userId = super.register(telephone, password);

        eventBus.post(userId);
        return userId;
    }
}
