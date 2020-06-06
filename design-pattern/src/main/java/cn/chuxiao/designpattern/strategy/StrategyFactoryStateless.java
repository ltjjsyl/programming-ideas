package cn.chuxiao.designpattern.strategy;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建,无状态，缓存
 */
public class StrategyFactoryStateless {

    public static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("A",new ConcreteStrategyA());
        strategies.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type){
        if(StringUtils.isEmpty(type)){
            throw new IllegalArgumentException("type is empty");
        }
        return strategies.get(type);
    }
}
