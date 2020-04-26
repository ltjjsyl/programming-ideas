package cn.chuxiao.designpattern.singleton.case1.origin;

public class UserController {
    private Logger logger = new Logger();

    public void login(String username, String password) {
        //...
        logger.log(username + " logined");
    }
}
