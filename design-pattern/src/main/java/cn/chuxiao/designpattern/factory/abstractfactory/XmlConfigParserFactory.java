package cn.chuxiao.designpattern.factory.abstractfactory;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;
import cn.chuxiao.designpattern.factory.simplefactory.XmlRuleConfigParser;

public class XmlConfigParserFactory implements IConfigParserFactory {
    @Override
    public IRuleConfigParser createRuleParser() {
        return new XmlRuleConfigParser();
    }

    @Override
    public ISystemConfigParser createSystemParser() {
        return new XmlSystemConfigParser();
    }
}

