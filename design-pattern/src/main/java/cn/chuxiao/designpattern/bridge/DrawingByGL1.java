package cn.chuxiao.designpattern.bridge;

public class DrawingByGL1 implements Drawing {
    private GraphLibary1 libary1 = new GraphLibary1();

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        libary1.draw_a_line(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(int x, int y, int r) {
        libary1.draw_a_circle(x, y, r);
    }
}
