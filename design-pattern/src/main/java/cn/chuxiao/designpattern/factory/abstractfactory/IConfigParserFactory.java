package cn.chuxiao.designpattern.factory.abstractfactory;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;

public interface IConfigParserFactory {
    IRuleConfigParser createRuleParser();

    ISystemConfigParser createSystemParser();

    //此处可以扩展新的parser类型，比如IBizConfigParser
}
