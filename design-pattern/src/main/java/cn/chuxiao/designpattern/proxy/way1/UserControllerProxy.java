package cn.chuxiao.designpattern.proxy.way1;

import cn.chuxiao.designpattern.proxy.IUserController;
import cn.chuxiao.designpattern.proxy.UserController;
import cn.chuxiao.designpattern.proxy.UserVo;

/**
 * 原始类和代理类实现相同的接口，是基于接口而非实现编程
 */
public class UserControllerProxy implements IUserController {

    private UserController userController;//委托

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
    }

    //UserControllerProxy使用举例
    public static void main(String[] args) {
        UserController userController = new UserController();
        UserControllerProxy userControllerProxy = new UserControllerProxy(userController);
    }

    @Override
    public UserVo login(String telephone, String psw) {
        //do other thing
        //...
        UserVo userVo = userController.login(telephone, psw);

        //do other thing
        //...

        return userVo;
    }

    @Override
    public UserVo register(String telephone, String psw) {
        //do other thing
        //...
        UserVo userVo = userController.login(telephone, psw);

        //do other thing
        //...

        return userVo;
    }
}
