package visitor.v2;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        Extractor extractor = new Extractor();
        for (ResourceFile file : resourceFiles) {
            //编译错误
            //函数重载是一种静态绑定，在编译时并不能获取对象的实际类型，
            //而是根据声明类型执行声明类型对应的方法,没有参数为ResourceFile的重载方法
            //extractor.extract2txt(file);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectoy) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new WordFile("b.word"));
        resourceFiles.add(new PptFile("c.ppt"));
        return resourceFiles;
    }
}

