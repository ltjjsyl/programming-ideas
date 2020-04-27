package cn.chuxiao.designpattern.factory.factorymethod;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser createParser();
}
