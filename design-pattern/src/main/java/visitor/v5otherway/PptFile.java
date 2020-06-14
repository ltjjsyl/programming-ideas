package visitor.v5otherway;



public class PptFile extends ResourceFile {

    public PptFile(String path) {
        super(path);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PPT;
    }
}
