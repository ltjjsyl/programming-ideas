package visitor.v1;

public class PptFile extends ResourceFile {

    public PptFile(String path) {
        super(path);
    }

    @Override
    protected void extract2Txt() {
        //...省略一大坨从PPT中抽取文本的代码...
        // ...将抽取出来的文本保存在跟filePath同名的.txt文件中...
        System.out.println("extract ppt to txt.");
    }
}
