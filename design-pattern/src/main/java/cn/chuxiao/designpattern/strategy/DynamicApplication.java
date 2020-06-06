package cn.chuxiao.designpattern.strategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用
 * 运行时动态确定，根据配置文件的配置决定使用哪种策略
 */
public class DynamicApplication {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        String type = properties.getProperty("type");

        Strategy strategy = StrategyFactoryStateless.getStrategy(type);
        strategy.algorithmInterface();
    }
}
