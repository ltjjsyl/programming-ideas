package cn.chuxiao.designpattern.builder.case1.config.v3;

import org.apache.commons.lang3.StringUtils;

//定义一个资源池配置类
//可配置项:有必填/非必填，有默认值
//构造者模式，避免对象存在无效状态，可读性，易用性提高
//可以做更多的校验
public class ResourcePoolConfig {

    private String name;//资源名称，必填，没有默认值
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    //用法
    //可读性，易用性提高

    public static void main(String[] args) {
        new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(12)
                .build();

    }

    //...省略getter方法...

    //将Builder类设计成了ResourcePoolConfig的内部类。
    //也可以将Builder类设计成独立的非内部类ResourcePoolConfigBuilder。
    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;//资源名称，必填，没有默认值
        private int maxTotal = DEFAULT_MAX_TOTAL;//最大总资源数量，非必填，默认值8
        private int maxIdle = DEFAULT_MAX_IDLE;//最大空闲资源数量，非必填，默认值8
        private int minIdle = DEFAULT_MIN_IDLE;//最大空闲资源数量，非必填，默认值0

        public ResourcePoolConfig build() {
            // 校验逻辑放到这里来做，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }

            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("name should not be empty.");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(Integer maxTotal) {
            if (maxTotal != null) {
                if (maxTotal <= 0) {
                    throw new IllegalArgumentException("maxTotal should be positive.");
                }
                this.maxTotal = maxTotal;
            }
            return this;
        }

        public Builder setMaxIdle(Integer maxIdle) {
            if (maxIdle != null) {
                if (maxIdle < 0) {
                    throw new IllegalArgumentException("minIdle should not be negative");
                }
                this.maxIdle = maxIdle;
            }
            return this;
        }

        public Builder setMinIdle(Integer minIdle) {
            if (minIdle != null) {
                if (minIdle < 0) {
                    throw new IllegalArgumentException("maxIdle should not be negative");
                }
                this.minIdle = minIdle;
            }
            return this;
        }
    }
}
