package cn.chuxiao.designprinciple.isp.case2;

import java.util.Collection;

// 按照接口隔离原则，应该把 count() 函数拆成几个更小粒度的函数，每个函数负责一个独立的统计功能
public class StatisticsV2 {
    private Long max;
    private Long min;
    private Long average;
    private Long sum;
    private Long percentile99;
    private Long percentile999;
    //... 省略 constructor/getter/setter 等方法... }

    public Long max(Collection<Long> dataSet) {
        //...
        return 0L;
    }

    public Long min(Collection<Long> dataSet) {
        //...
        return 0L;
    }

    public Long average(Collection<Long> dataSet) {
        //...
        return 0L;
    }

    // ... 省略其他统计函数...
}