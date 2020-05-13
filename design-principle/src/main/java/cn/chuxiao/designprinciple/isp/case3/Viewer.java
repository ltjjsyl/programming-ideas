package cn.chuxiao.designprinciple.isp.case3;

import java.util.Map;

//配置信息查看
public interface Viewer {

    String outputInPlainText();

    Map<String, String> output();
}
