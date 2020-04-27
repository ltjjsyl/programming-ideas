package cn.chuxiao.designpattern.sington.case2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 唯一ID生成器(唯一递增ID生成器）
 * 如果程序中有两个对象，那就会存在生成重复 D的情况，所以应该将ID生成器类设计为单例
 */
public class IdGenerator {

    private static final IdGenerator instance = new IdGenerator();

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        IdGenerator.getInstance().getId();
    }

    public long getId() {
        return id.incrementAndGet();
    }
}
