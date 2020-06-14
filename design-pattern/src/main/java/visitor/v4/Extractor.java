package visitor.v4;


public class Extractor implements Visitor {


    public void visit(PptFile pptFile) {
        //...
        System.out.println("Extract PPT.");
    }

    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF.");
    }

    public void visit(WordFile wordFile) {
        //...
        System.out.println("Extract WORD.");
    }
}
