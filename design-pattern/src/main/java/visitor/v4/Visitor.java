package visitor.v4;

public interface Visitor {
    void visit(PdfFile pdfFile);

    void visit(PptFile pptFile);

    void visit(WordFile wordFile);
}
