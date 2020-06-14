package visitor.v3;


public class PptFile extends ResourceFile {

    public PptFile(String path) {
        super(path);
    }

    @Override
    public void accept(Extractor extractor) {
        //...
        extractor.extract2txt(this);
    }

    @Override
    public void accept(Compressor compressor) {
        //...
        compressor.compress(this);
    }
}
