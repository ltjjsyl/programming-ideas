package visitor.v4;


import visitor.v3.Compressor;

public class PdfFile extends ResourceFile {

    public PdfFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        //...
        visitor.visit(this);
    }
}
