package cn.chuxiao.designpattern.singleton.impl.way1;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 唯一ID生成器(唯一递增ID生成器）
 * <p>
 * 饿汉式
 */
public class IdGenerator {

    private static final IdGenerator instance = new IdGenerator();

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
