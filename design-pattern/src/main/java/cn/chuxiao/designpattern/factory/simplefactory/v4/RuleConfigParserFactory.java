package cn.chuxiao.designpattern.factory.simplefactory.v4;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;
import cn.chuxiao.designpattern.factory.simplefactory.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//为了节省内存和对象创建的时间，将parser事先创建好缓存起来
//简单工厂+单例
public class RuleConfigParserFactory {

    private static final Map<String, IRuleConfigParser> cachedParsers = new ConcurrentHashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
        cachedParsers.put("properties", new PropertiesRuleConfigParser());
    }

    //静态工厂方法，也叫简单工厂,复用对象
    public static IRuleConfigParser createParser(String configFormat) {

        if (null == configFormat || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException全凭你自己说了算
        }

        return cachedParsers.get(configFormat.toLowerCase());
    }
}
