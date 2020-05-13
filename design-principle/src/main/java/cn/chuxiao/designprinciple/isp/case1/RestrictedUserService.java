package cn.chuxiao.designprinciple.isp.case1;

public interface RestrictedUserService {
    boolean deleteUserByCellphone(String cellphone);

    boolean deleteUserById(long id);
}
