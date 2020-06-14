package visitor.v5otherway;


public class WordFile extends ResourceFile {

    public WordFile(String path) {
        super(path);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.WORD;
    }
}
