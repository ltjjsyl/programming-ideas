package cn.chuxiao.designpattern.factory.factorymethod.v2;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;
import cn.chuxiao.designpattern.factory.RuleConfig;
import cn.chuxiao.designpattern.factory.factorymethod.IRuleConfigParserFactory;


public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {

        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);

        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        IRuleConfigParser parser = parserFactory.createParser();

        //从ruleConfigFilePath文件中读取配置文本到configText中
        String configText = "";

        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...
        // 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
