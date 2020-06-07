package cn.chuxiao.designpattern.observer.case1.v2;

import cn.chuxiao.designpattern.observer.case1.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发一个P2P投资理财系统，用户注册成功之后，会给用户发放投资体验金
 * <p>
 * 如果需求频繁变动，比如，用户注册成功之后，不再发放体验金，而是改为发放优券，并且还要给用户发送一封“欢迎注册成功”的站内信。
 * 这种情况下，就需要频繁地修改 register() 函数中的代码，违反开闭原则。
 * 而且，如果注册成功之后需要执行的后续操作越来越多，那register() 函数的逻辑会变得越来越复杂，也就影响到代码的可读性和可维 护性。
 * <p>
 * 引入观察者模式
 */
public class UserController {

    private UserService userService;  //依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> regObservers) {
        this.regObservers = regObservers;
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        Long userId = userService.register(telephone, password);

        for (RegObserver o : regObservers) {
            o.handleRegMessage(userId);
        }
        return userId;
    }
}
