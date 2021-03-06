package cn.chuxiao.designpattern.observer.case1.v3;

import cn.chuxiao.designpattern.observer.case1.NotificationService;
import cn.chuxiao.designpattern.observer.case1.v2.RegObserver;

public class RegNotificationObserver implements RegObserver {

    private NotificationService notificationService;

    @Override
    public void handleRegMessage(Long userId) {
        notificationService.sendInboxMessage(userId, "welcome ...");
    }
}
