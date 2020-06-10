package cn.chuxiao.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicHelloWorldProxy {


    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new Handler(target));

    }


    private static class Handler implements InvocationHandler {

        private Object target;

        public Handler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Logger.startLog();
            Object result = method.invoke(target, args);
            Logger.endLog();
            return result;
        }
    }
}
