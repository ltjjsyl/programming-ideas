package cn.chuxiao.designpattern.compose.example2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 设计一个类来表示文件系统中的目录，能方便地实现下面这些功能：
 * 动态地添加、删除某个目录下的子目录或文件；
 * 统计指定目录下的文件个数；
 * 统计指定目录下的文件总大小
 *
 * 开发的是一个大型系统，
 * 从扩展性（文件或目录可能会对应不同的操作）、
 * 业务建模（文件和目录从业务上是两个概念）、
 * 代码的可读性（文件和目录区分对待更加符合人们对业务的认知）的角度来说，
 * 对文件和目录进行区分设计，定义为File和Directory两个类。
 */
public abstract class FileSystemNodeV2 {

    private String path;

    public FileSystemNodeV2(String path) {
        this.path = path;

    }

    public String getPath() {
        return this.path;
    }

    public abstract long countSizeOfFiles();

    public abstract int countNumOfFiles();
}
