package cn.chuxiao.designpattern.sington.impl.way4;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 唯一ID生成器(唯一递增ID生成器）
 * <p>
 * 静态内部类
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    private static class SingletonHolder {
        private static final IdGenerator instance = new IdGenerator();
    }
}
