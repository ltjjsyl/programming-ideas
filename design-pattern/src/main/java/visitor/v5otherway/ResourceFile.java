package visitor.v5otherway;

/**
 * 从网站上爬取了很多资源文件，它们的格式有三种：PDF、PPT、Word。
 * 现在要开发一个工具来处理这批资源文件。
 * 这个工具的其中一个功能是，把这些资源文件中的文本内容抽取出来放到txt文件中
 * <p>
 * 变化：
 * 增加功能
 * 增加资源文件类型
 *
 * 还可以利用工厂模式来实现，定义一个包含extract2txt()接口函数的 Extractor 接口。
 * PdfExtractor、 PPTExtractor、WordExtractor 类实现Extractor接口，
 * 并且在各自的 extract2txt()函数 中，分别实现 Pdf、PPT、Word 格式文件的文本内容抽取。
 * ExtractorFactory工厂类根据不同的文件类型，返回不同的Extractor。
 */
public abstract class ResourceFile {

    private String path;

    public ResourceFile(String path) {
        this.path = path;
    }

    public abstract ResourceFileType getType();
}
