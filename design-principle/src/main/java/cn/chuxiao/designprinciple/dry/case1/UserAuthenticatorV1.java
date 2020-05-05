package cn.chuxiao.designprinciple.dry.case1;

import org.apache.commons.lang3.StringUtils;


public class UserAuthenticatorV1 {
    public void authenticate(String username, String password) {
        if (!isValidUsernameOrPassword(username)) {
            // ...throw InvalidUsernameException...
        }
        if (!isValidUsernameOrPassword(password)) {
            // ...throw InvalidPasswordException...    }
        }
        // ... 省略其他代码...
    }

    //违反了“单一职责原则”和“接口隔离原则
    //语义不重复，后续实现逻辑变化修改麻烦
    private boolean isValidUsernameOrPassword(String username) {

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
        for (int i = 0; i < length; ++i) {
            char c = username.charAt(i);
            if (!(c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '.') {
                return false;
            }
        }
        return true;
    }
}
