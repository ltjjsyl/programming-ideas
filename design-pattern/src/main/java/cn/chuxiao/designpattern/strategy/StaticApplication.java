package cn.chuxiao.designpattern.strategy;

import java.io.IOException;

/**
 * 使用
 * 非运行时动态确定，在代码中指定使用哪种策略
 * 多态
 */
public class StaticApplication {

    public static void main(String[] args) throws IOException {

        Strategy strategy = StrategyFactoryStateless.getStrategy("A");
        strategy.algorithmInterface();
    }
}
