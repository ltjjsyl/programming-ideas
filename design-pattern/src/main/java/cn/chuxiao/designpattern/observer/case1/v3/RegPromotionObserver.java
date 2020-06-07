package cn.chuxiao.designpattern.observer.case1.v3;

import cn.chuxiao.designpattern.observer.case1.PromotionService;
import cn.chuxiao.designpattern.observer.case1.v2.RegObserver;

public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService;//依赖注入

    @Override
    public void handleRegMessage(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
