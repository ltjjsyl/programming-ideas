package cn.chuxiao.designpattern.builder.case1.config.v2;

import org.apache.commons.lang3.StringUtils;

//定义一个资源池配置类
//可配置项:有必填/非必填，有默认值
//使用setter方法避免构造器过多参数
public class ResourcePoolConfig {

    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;//资源名称，必填，没有默认值
    private int maxTotal = DEFAULT_MAX_TOTAL;//最大总资源数量，非必填，默认值8
    private int maxIdle = DEFAULT_MAX_IDLE;//最大空闲资源数量，非必填，默认值8
    private int minIdle = DEFAULT_MIN_IDLE;//最大空闲资源数量，非必填，默认值0

    public ResourcePoolConfig(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
    }

    //用法
    //可读性，易用性提高
    //校验必填项是否已经填写的逻辑就无处安放
    //配置项之间的依赖关系或者约束条件的校验逻辑就无处安放
    //希望 ResourcePoolConfig 类对象是不可变对象不能实现
    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig("test");
        config.setMaxTotal(16);
        config.setMaxIdle(8);
    }

    public void setMaxTotal(Integer maxTotal) {
        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }
    }

    public void setMaxIdle(Integer maxIdle) {
        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("minIdle should not be negative");
            }
            this.maxIdle = maxIdle;
        }
    }

    public void setMinIdle(Integer minIdle) {
        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative");
            }
            this.minIdle = minIdle;
        }

    }

    //...省略getter方法
}
