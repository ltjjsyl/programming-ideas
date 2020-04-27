package cn.chuxiao.designpattern.factory.simplefactory.v3;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;
import cn.chuxiao.designpattern.factory.simplefactory.*;

public class RuleConfigParserFactory {

    //静态工厂方法，也叫简单工厂，每次都新创建
    public static IRuleConfigParser createParser(String ruleConfigFileExtension) {

        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new PropertiesRuleConfigParser();
        }

        return parser;
    }
}
