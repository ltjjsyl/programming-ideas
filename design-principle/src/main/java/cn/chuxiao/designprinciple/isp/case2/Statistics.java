package cn.chuxiao.designprinciple.isp.case2;

import java.util.Collection;

// count() 函数的功能不够单一，包含很多不同的统计功能，比如，求最大值、小值、平均值等等。
// 按照接口隔离原则，应该把 count() 函数拆成几个更小粒度的函数，每个函数负责一个独立的统计功能
public class Statistics {
    private Long max;
    private Long min;
    private Long average;
    private Long sum;
    private Long percentile99;
    private Long percentile999;
    //... 省略 constructor/getter/setter 等方法... }

    public Statistics count(Collection<Long> dataSet) {
        Statistics statistics = new Statistics();
        //... 省略计算逻辑...
        return statistics;
    }
}
