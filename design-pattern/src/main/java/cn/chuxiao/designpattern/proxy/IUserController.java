package cn.chuxiao.designpattern.proxy;

public interface IUserController {

    UserVo login(String telephone, String psw);

    UserVo register(String telephone, String psw);
}
