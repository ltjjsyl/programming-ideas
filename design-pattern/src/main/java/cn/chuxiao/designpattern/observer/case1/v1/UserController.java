package cn.chuxiao.designpattern.observer.case1.v1;

import cn.chuxiao.designpattern.observer.case1.PromotionService;
import cn.chuxiao.designpattern.observer.case1.UserService;

/**
 * 开发一个P2P投资理财系统，用户注册成功之后，会给用户发放投资体验金
 */
public class UserController {

    private UserService userService;  //依赖注入
    private PromotionService promotionService;  //依赖注入

    //注册接口做了两件事情，注册和发放体验金，违反单一职责原则，
    //但是，如果没有扩展和修改的需求，现在的代码实现是可以接受的
    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        Long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
