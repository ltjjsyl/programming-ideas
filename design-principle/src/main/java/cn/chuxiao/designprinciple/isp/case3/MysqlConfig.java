package cn.chuxiao.designprinciple.isp.case3;

import java.util.Map;

public class MysqlConfig implements Viewer {

    public MysqlConfig(ConfigSource configSource) {

    }


    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
