package visitor.v3;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        Extractor extractor = new Extractor();
        for (ResourceFile file : resourceFiles) {
            //根据多态特性，程序会调用实际类型的accept函数，比如PdfFile的accept，
            //accept代码中的this类型是PdfFile的， 在编译的时候就确定了，
            //所以会调用extractor的extract2txt(PdfFile pdfFile) 这个重载函数。
            //理解访问者模式的关键
            file.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for (ResourceFile file : resourceFiles) {
            file.accept(compressor);
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

