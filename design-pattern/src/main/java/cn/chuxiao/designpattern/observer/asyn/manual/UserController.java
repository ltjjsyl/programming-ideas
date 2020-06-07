package cn.chuxiao.designpattern.observer.asyn.manual;

import cn.chuxiao.designpattern.observer.case1.UserService;
import cn.chuxiao.designpattern.observer.case1.v2.RegObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * 第二种实现方式，利用线程池解决了第一种实现方式的问题，
 * 但线程池、异步执行逻辑都耦合在了 register() 函数中，增加了这部分业务代码的维护成本
 * 线程池满的场景一样需要考虑
 */
public class UserController {

    private UserService userService;  //依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();
    private Executor executor;

    public UserController(Executor executor) {
        this.executor = executor;
    }

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> regObservers) {
        this.regObservers = regObservers;
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        Long userId = userService.register(telephone, password);

        for (RegObserver o : regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    o.handleRegMessage(userId);
                }
            });
        }
        return userId;
    }
}
