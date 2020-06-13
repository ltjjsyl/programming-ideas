package cn.chuxiao.designpattern.compose.example2;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNodeV2 {

    private List<FileSystemNodeV2> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public long countSizeOfFiles() {
        long sizeOfFiles = 0;
        for (FileSystemNodeV2 node : subNodes) {
            sizeOfFiles += node.countSizeOfFiles();
        }
        return sizeOfFiles;
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNodeV2 node : subNodes) {
            numOfFiles += node.countNumOfFiles();
        }
        return numOfFiles;
    }

    public void addSubNode(FileSystemNodeV2 fileOrDir) {
        subNodes.add(fileOrDir);
    }

    //迭代的过程不能删除
    public void removeSubNode(FileSystemNodeV2 fileOrDir) {
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
}
