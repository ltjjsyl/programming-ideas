package visitor.v4;


public class Compressor implements Visitor {

    public void visit(PptFile pptFile) {
        //...
        System.out.println("Compress PPT.");
    }

    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Compress PDF.");
    }

    public void visit(WordFile wordFile) {
        //...
        System.out.println("Compress WORD.");
    }
}
