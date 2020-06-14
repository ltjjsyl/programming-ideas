package cn.chuxiao.designpattern.bridge;

public class Circle implements Shape {

    private int x;
    private int y;
    private int r;
    private Drawing drawing;

    public Circle(int x, int y, int r, Drawing drawing) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.drawing = drawing;
    }

    public Circle(int x, int y, int r) {
        this(x, y, r, new DrawingByGL1());
    }

    public void setDrawing(Drawing drawing) {
        this.drawing = drawing;
    }

    @Override
    public void draw() {
        drawing.drawCircle(x, y, r);
    }
}
