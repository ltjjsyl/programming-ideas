package visitor.v3;


public class WordFile extends ResourceFile {

    public WordFile(String path) {
        super(path);
    }

    @Override
    protected void accept(Extractor extractor) {
        //...
        extractor.extract2txt(this);
    }

    @Override
    public void accept(Compressor compressor) {
        //...
        compressor.compress(this);
    }
}
