package cn.chuxiao.designpattern.singleton.case1.fix;

public class UserController {

    public void login(String username, String password) {
        //...
        Logger.getInstance().log(username + " logined");
    }
}
