package cn.chuxiao.designpattern.observer.case1.v2;

import cn.chuxiao.designpattern.observer.case1.PromotionService;

public class RegPromotionObserver implements RegObserver {

    private PromotionService promotionService;//依赖注入

    @Override
    public void handleRegMessage(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
