package cn.chuxiao.designpattern.builder.case1.config.v1;

import org.apache.commons.lang3.StringUtils;

//定义一个资源池配置类
//可配置项:有必填/非必填，有默认值
public class ResourcePoolConfig {

    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;//资源名称，必填，没有默认值
    private int maxTotal = DEFAULT_MAX_TOTAL;//最大总资源数量，非必填，默认值8
    private int maxIdle = DEFAULT_MAX_IDLE;//最大空闲资源数量，非必填，默认值8
    private int minIdle = DEFAULT_MIN_IDLE;//最大空闲资源数量，非必填，默认值0

    //使用包装类型的原因是通过null来表示使用默认值
    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;

        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }

        if (maxIdle != null) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("maxIdle should not be negative");
            }
            this.maxIdle = maxIdle;
        }

        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not be negative");
            }
            this.minIdle = minIdle;
        }
    }

    //...省略getter方法


    //用法
    // 参数太多，导致可读性差、参数可能传递错误
    public static void main(String[] args) {
        new ResourcePoolConfig("test", 8, 8, 0);
    }
}
