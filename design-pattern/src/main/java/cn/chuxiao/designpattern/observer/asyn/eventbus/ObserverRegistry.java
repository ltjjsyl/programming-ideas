package cn.chuxiao.designpattern.observer.asyn.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Observer 注册表
 * <p>
 * 一个比较有技巧的地方是CopyOnWriteArraySet的使用。
 * CopyOnWriteArraySet，顾名思义，在写入数据的时候，会创建一个新的set，并且将原始数据clone到新的set中，
 * 在新的set中写入数据完成之后，再用新的set替换老的set。
 * 这样就能保证在写入数据的时候，不影响数据的读取操作，以此来解决读写并发问题。
 * 除此之外，CopyOnWriteSet还通过加锁的方式，避免了并发写冲突
 */
public class ObserverRegistry {
    //key是post消息类型，value对应观察者的符合方法
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = Maps.newConcurrentMap();

    public void register(Object observer) {

        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();

        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)) {
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }

    //找到观察者对象符合的ObserverAction
    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {

        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotatedMethod(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }

        return observerActions;
    }

    //找到@Subscribe注解且参数为1的方法
    private List<Method> getAnnotatedMethod(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters. " +
                                "Subscriber methods must have exactly 1 parameter",
                        method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }

        return annotatedMethods;
    }
}
