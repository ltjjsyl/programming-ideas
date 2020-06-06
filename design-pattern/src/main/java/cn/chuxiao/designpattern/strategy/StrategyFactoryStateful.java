package cn.chuxiao.designpattern.strategy;

import org.apache.commons.lang3.StringUtils;

/**
 * 创建,有状态，new
 */
public class StrategyFactoryStateful {

    public static Strategy getStrategy(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("type is empty");
        }
        //这种实现方式相当于把if-else分支逻辑，从使用类中转移到了工厂类中
        if (type.equals("A")) {
            return new ConcreteStrategyA();
        } else if (type.equals("B")) {
            return new ConcreteStrategyB();
        }

        return null;
    }
}
