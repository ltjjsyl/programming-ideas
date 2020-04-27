package cn.chuxiao.designpattern.sington.impl.way5;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 唯一ID生成器(唯一递增ID生成器）
 * <p>
 * 枚举方式
 */
public enum IdGenerator {

    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
