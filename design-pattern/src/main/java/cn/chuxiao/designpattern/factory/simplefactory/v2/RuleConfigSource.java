package cn.chuxiao.designpattern.factory.simplefactory.v2;

import cn.chuxiao.designpattern.factory.IRuleConfigParser;
import cn.chuxiao.designpattern.factory.InvalidRuleConfigException;
import cn.chuxiao.designpattern.factory.RuleConfig;
import cn.chuxiao.designpattern.factory.simplefactory.*;

public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = createParser(ruleConfigFileExtension);

        if (null == parser) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }

        //从ruleConfigFilePath文件中读取配置文本到configText中
        String configText = "";

        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    //规范和重构:为了让代码逻辑更加清晰，可读性更好，将功能独立的代码块封装成函数
    private IRuleConfigParser createParser(String ruleConfigFileExtension) {

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

    private String getFileExtension(String filePath) {
        //...
        // 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
