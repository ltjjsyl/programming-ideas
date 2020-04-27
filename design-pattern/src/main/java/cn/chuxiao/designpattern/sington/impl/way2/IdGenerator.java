package cn.chuxiao.designpattern.sington.impl.way2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 唯一ID生成器(唯一递增ID生成器）
 * <p>
 * 懒汉式
 */
public class IdGenerator {

    private static IdGenerator instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static synchronized IdGenerator getInstance() {
        if (null == instance) {
            instance = new IdGenerator();
        }

        return instance;
    }


    public long getId() {
        return id.incrementAndGet();
    }
}
