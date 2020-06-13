package cn.chuxiao.designpattern.compose.example2;

public class File extends FileSystemNodeV2 {

    public File(String path) {
        super(path);
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(getPath());
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }
}