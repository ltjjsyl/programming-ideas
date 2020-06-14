package visitor.v4;


public class WordFile extends ResourceFile {

    public WordFile(String path) {
        super(path);
    }

    @Override
    public void accept(Visitor visitor) {
        //...
        visitor.visit(this);
    }
}
