package cn.chuxiao.designpattern.proxy.way2;


import cn.chuxiao.designpattern.proxy.UserController;
import cn.chuxiao.designpattern.proxy.UserVo;

/**
 * 采用继承的方式,让代理类继承原始类，然后扩展附加功能
 */
public class UserControllerProxy extends UserController {


    public UserControllerProxy() {
        //...
    }

    //UserControllerProxy使用举例
    public static void main(String[] args) {
        UserControllerProxy userControllerProxy = new UserControllerProxy();
    }

    @Override
    public UserVo login(String telephone, String psw) {
        //do other thing
        //...
        UserVo userVo = super.login(telephone, psw);

        //do other thing
        //...

        return userVo;
    }

    @Override
    public UserVo register(String telephone, String psw) {
        //do other thing
        //...
        UserVo userVo = super.login(telephone, psw);

        //do other thing
        //...

        return userVo;
    }
}
