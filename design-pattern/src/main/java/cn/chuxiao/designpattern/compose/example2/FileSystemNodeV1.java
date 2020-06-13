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
 * 简单实现
 */
public class FileSystemNodeV1 {

    private String path;
    private boolean isFile;

    private List<FileSystemNodeV1> subNodes = new ArrayList<>();

    public FileSystemNodeV1(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public String getPath() {
        return this.path;
    }

    public void addSubNode(FileSystemNodeV1 fileOrDir) {
        subNodes.add(fileOrDir);
    }

    //迭代的过程不能删除
    public void removeSubNode(FileSystemNodeV1 fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }
        if (i < size) {
            subNodes.remove(i);
        }
    }

    public long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) {
                return 0;
            }
            return file.length();
        }
        long sizeOfFiles = 0;
        for (FileSystemNodeV1 node : subNodes) {
            sizeOfFiles += node.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        int numOfFiles = 0;
        for (FileSystemNodeV1 node : subNodes) {
            numOfFiles += node.countNumOfFiles();
        }
        return numOfFiles;
    }
}
