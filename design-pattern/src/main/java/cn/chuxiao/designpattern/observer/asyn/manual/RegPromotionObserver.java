package cn.chuxiao.designpattern.observer.asyn.manual;

import cn.chuxiao.designpattern.observer.case1.PromotionService;
import cn.chuxiao.designpattern.observer.case1.v2.RegObserver;

/**
 * 第一种实现方式,在每个handleRegSuccess() 函数中创建一个新的线程执行代码逻辑
 *
 * 频繁地创建和销毁线程比较耗时，并且并发线程数无法控制，创建过多的线程会导致堆栈溢出
 * */
public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService;//依赖注入

    @Override
    public void handleRegMessage(Long userId) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
}
