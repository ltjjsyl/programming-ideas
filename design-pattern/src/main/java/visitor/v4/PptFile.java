package visitor.v4;


public class PptFile extends ResourceFile {

    public PptFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        //...
        visitor.visit(this);
    }
}
