package cn.chuxiao.designpattern.sington.case1.fix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一个往文件中打印日志的Logger类，单例实现
 */
public class Logger {

    private static final Logger instance = new Logger();

    private FileWriter fileWriter;

    private Logger() {
        File logFile = new File("logger.txt");
        try {
            fileWriter = new FileWriter(logFile, true);//true表示追加写
        } catch (IOException ignore) {
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        try {
            fileWriter.write(message);
        } catch (IOException ignore) {
        }
    }
}
