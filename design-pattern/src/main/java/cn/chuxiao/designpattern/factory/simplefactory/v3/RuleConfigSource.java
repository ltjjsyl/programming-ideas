package cn.chuxiao.designpattern.factory.simplefactory.v3;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;
import cn.chuxiao.designpattern.factory.InvalidRuleConfigException;
import cn.chuxiao.designpattern.factory.RuleConfig;


//为了让类的职责更加单一、代码更加清晰，进一步将createParser()函数剥离 到一个独立的类中，
//让这个类只负责对象的创建。而这个类就是简单工厂模式类
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);

        if (null == parser) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

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
