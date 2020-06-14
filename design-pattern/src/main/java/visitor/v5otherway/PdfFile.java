package visitor.v5otherway;


public class PdfFile extends ResourceFile {

    public PdfFile(String path) {
        super(path);
    }

    @Override
    public ResourceFileType getType() {
        return ResourceFileType.PDF;
    }
}
