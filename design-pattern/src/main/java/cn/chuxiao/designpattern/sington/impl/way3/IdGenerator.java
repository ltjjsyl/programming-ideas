package cn.chuxiao.designpattern.sington.impl.way3;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 唯一ID生成器(唯一递增ID生成器）
 * <p>
 * 双重检查
 */
public class IdGenerator {

    //TODO
    //因为指令重排序，可能会导致IdGenerator对象被new出来，并且赋值给instance之后，还没来得及初始化
    //（执行构造函数中的代码逻辑），就被另一个线程使用了。
    //要解决这个问题，需要给instance成员变量加上volatile关键字，禁止指令重排序才行。
    //实际上，只有很低版本的Java才会有这个问题，高版本的Java已经在JDK内部实现中解决了这个问题
    //（解决的方法很简单，只要把对象new操作和初始化操作设计为原子操作，就自然能禁止重排序）。
    private static IdGenerator instance;

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {

        if (null == instance) {
            synchronized (IdGenerator.class) {//类级别的锁
                if (null == instance) {
                    instance = new IdGenerator();
                }
            }
        }

        return instance;
    }


    public long getId() {
        return id.incrementAndGet();
    }
}
