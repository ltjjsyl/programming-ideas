package cn.chuxiao.designprinciple.dry.case1;

import org.apache.commons.lang3.StringUtils;

/**
 * 实现逻辑重复，语义不重复
 */
public class UserAuthenticatorV2 {
    public void authenticate(String username, String password) {
        if (!isValidUsername(username)) {
            // ...throw InvalidUsernameException...
        }
        if (!isValidPassword(password)) {
            // ...throw InvalidPasswordException...    }
        }
        // ... 省略其他代码...
    }

    private boolean isValidUsername(String username) {

        // check not null, not empty
        if (StringUtils.isBlank(username)) {
            return false;
        }
        // check length: 4~64
        int length = username.length();
        if (length < 4 || length > 64) {
            return false;
        }

        // contains only lowcase characters
        if (!StringUtils.isAllLowerCase(username)) {
            return false;
        }
        // contains only a~z,0~9,dot
        if (!onlyContains(username, "a~z0-9.")) {
            return false;
        }

        return true;
    }

    //TODO 只是示例
    //包含重复代码的问题，可以通过抽象成更细粒度函数的方式来解决
    private boolean onlyContains(String str, String charlist) {
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (!charlist.contains(c + "")) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPassword(String password) {
        // check not null, not empty
        if (StringUtils.isBlank(password)) {
            return false;
        }
        // check length: 4~64
        int length = password.length();
        if (length < 4 || length > 64) {
            return false;
        }
        // contains only lowcase characters
        if (!StringUtils.isAllLowerCase(password)) {
            return false;
        }
        // contains only a~z,0~9,dot
        if (!onlyContains(password, "a~z0-9.")) {
            return false;
        }
        return true;
    }
}
