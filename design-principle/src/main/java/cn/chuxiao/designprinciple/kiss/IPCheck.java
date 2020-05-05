package cn.chuxiao.designprinciple.kiss;

import org.apache.commons.lang3.StringUtils;

/**
 * 检查输入的字符串 ipAddress 是否是合法的 IPV4 地址。
 * 一个合法的 IPV4 地址由四个数字组成，并且通过“.”来进行分割。每组数字的取值范围是 0~255
 * 第一组数字比较特殊，不允许为 0
 */
public class IPCheck {

    // 第一种实现方式: 使用正则表达式
    public boolean isValidIpAddressV1(String ipAddress) {
        if (StringUtils.isBlank(ipAddress)) {
            return false;
        }
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        return ipAddress.matches(regex);
    }

    // 第二种实现方式: 使用现成的工具类，推荐方式
    public boolean isValidIpAddressV2(String ipAddress) {
        if (StringUtils.isBlank(ipAddress)) {
            return false;
        }
        //String 的spilt方法传入的是一个正则表达式。注意，参数regex是个正则表达式
        //优先使用StringUtils split和splitPreserveAllTokens(存在有些字段空缺的情况)
        String[] ipUnits = StringUtils.split(ipAddress, ".");
        if (ipUnits == null || ipUnits.length < 4) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int ipUnitIntValue;
            try {
                ipUnitIntValue = Integer.parseInt(ipUnits[i]);
            } catch (NumberFormatException e) {
                return false;
            }

            if (ipUnitIntValue < 0 || ipUnitIntValue > 255) {
                return false;
            }
            if (i == 0 && ipUnitIntValue == 0) {
                return false;
            }
        }

        return true;
    }

    // 第三种实现方式: 不使用任何工具类
    // 性能要比第二种实现方式高一些,实际上是一种过度优化（除非这是性能瓶颈）
    public boolean isValidIpAddressV3(String ipAddress) {
        if (StringUtils.isBlank(ipAddress)) {
            return false;
        }
        char[] ipChars = ipAddress.toCharArray();
        int length = ipChars.length;
        int ipUnitIntValue = -1;
        boolean isFirstUnit = true;
        int unitsCount = 0;
        for (int i = 0; i < length; ++i) {
            char c = ipChars[i];
            if (c == '.') {
                if (ipUnitIntValue < 0 || ipUnitIntValue > 255) {
                    return false;
                }
                if (isFirstUnit && ipUnitIntValue == 0) {
                    return false;
                }

                if (isFirstUnit) {
                    isFirstUnit = false;
                }
                ipUnitIntValue = -1;
                unitsCount++;
                continue;
            }
            if (c < '0' || c > '9') {
                return false;
            }
            if (ipUnitIntValue == -1) {
                ipUnitIntValue = 0;
            }
            ipUnitIntValue = ipUnitIntValue * 10 + (c - '0');
        }

        if (ipUnitIntValue < 0 || ipUnitIntValue > 255) {
            return false;
        }
        if (unitsCount != 3) {
            return false;
        }
        return true;
    }
}
