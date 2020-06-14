package visitor.v4;

/**
 * 从网站上爬取了很多资源文件，它们的格式有三种：PDF、PPT、Word。
 * 现在要开发一个工具来处理这批资源文件。
 * 这个工具的其中一个功能是，把这些资源文件中的文本内容抽取出来放到txt文件中
 * <p>
 * 变化：
 * 增加功能
 * 增加资源文件类型
 * <p>
 * 这种方式对于增加资源文件类型所以的visitor相关的类都需要修改
 * 增加功能符合开闭原则
 */
public abstract class ResourceFile {

    private String path;

    public ResourceFile(String path) {
        this.path = path;
    }

    protected abstract void accept(Visitor visitor);
}
