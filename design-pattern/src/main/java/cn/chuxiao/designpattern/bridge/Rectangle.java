package cn.chuxiao.designpattern.bridge;

public class Rectangle implements Shape {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Drawing drawing;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void draw() {
        drawing.drawLine(x1, y1, x1, y2);
        drawing.drawLine(x1, y1, x2, y1);
        drawing.drawLine(x1, y2, x2, y2);
        drawing.drawLine(x2, y1, x2, y2);
    }
}
