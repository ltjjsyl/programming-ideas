package cn.chuxiao.designprinciple.isp.case1;

/**
 * 删除用户是一个非常慎重的操作，只希望通过后台管理系统来执行，所以这个接口只限于给后台管理系统使用。
 * 如果把它放到 UserService 中，那所有使用到UserService的系统，都可以调用这个接口。
 * 不加限制地被其他业务系统调用，就有可能导致误删用户
 * <p>
 * 从代码设计的层面，尽量避免接口被误用。
 * 参照接口隔离原则，调用者不应该强迫依赖它不需要的接口，
 * 将删除接口单独放到另外一个接口RestrictedUserService中，
 * 然后将RestrictedUserService只打包提供给后台管理系统来使用
 */
public class UserServiceImpl implements UserService, RestrictedUserService {
    @Override
    public boolean register(String cellphone, String password) {
        return false;
    }

    @Override
    public boolean login(String cellphone, String password) {
        return false;
    }

    @Override
    public UserInfo getUserInfoById(long id) {
        return null;
    }

    @Override
    public UserInfo getUserInfoByCellphone(String cellphone) {
        return null;
    }

    @Override
    public boolean deleteUserByCellphone(String cellphone) {
        return false;
    }

    @Override
    public boolean deleteUserById(long id) {
        return false;
    }
}
