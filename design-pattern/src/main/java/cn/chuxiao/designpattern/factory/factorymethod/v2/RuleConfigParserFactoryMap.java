package cn.chuxiao.designpattern.factory.factorymethod.v2;

import cn.chuxiao.designpattern.factory.factorymethod.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 因为工厂类只包含方法，不包含成员变量，完全可以复用，
// 不需要每次都创建新的工厂类对象，所以，工厂方法的第二种实现思路更加合适。
public class RuleConfigParserFactoryMap { //工厂的工厂，工厂方法模式
    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new ConcurrentHashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }
}