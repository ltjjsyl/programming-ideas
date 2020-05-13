package cn.chuxiao.designprinciple.isp.case1;

public interface UserService {
    boolean register(String cellphone, String password);

    boolean login(String cellphone, String password);

    UserInfo getUserInfoById(long id);

    UserInfo getUserInfoByCellphone(String cellphone);
}

