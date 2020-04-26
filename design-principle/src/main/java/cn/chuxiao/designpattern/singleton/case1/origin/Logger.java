package cn.chuxiao.designpattern.singleton.case1.origin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一个往文件中打印日志的Logger类
 */
public class Logger {

    private FileWriter fileWriter;

    public Logger() {
        File logFile = new File("logger.txt");
        try {
            //多个调用者并发写日志到logger.txt文件（竞争资源）中，有可能存在日志信息互相覆盖的情况
            fileWriter = new FileWriter(logFile, true);//true表示追加写

            //解决思路：加锁
            //对象锁，无作用
            // FileWriter是线程安全的，内部实现中加了对象级别的锁，因此，再加对象级别的锁实际上是多此一举
            //synchronized (this){
            //    fileWriter = new FileWriter(logFile, true);//true表示追加写
            //}

            //类锁，起作用，效率问题
            //synchronized (Logger.class){
            //    fileWriter = new FileWriter(logFile, true);//true表示追加写
            //}

            //使用分布式锁，实现较难

            //并发队列（eg:BlockingQueue),稍微复杂,生产者消费者的思路（消息队列...)
            //多个线程同时往并发队列里写日志，一个单独的线程负责将并发队列中的数据，写入到日志文件

            //单例模式，思路简单些
        } catch (IOException ignore) {
        }
    }

    public void log(String message) {
        try {
            fileWriter.write(message);
        } catch (IOException ignore) {
        }
    }
}
