package cn.chuxiao.designpattern.bridge;

public class DrawingByGL2 implements Drawing {

    private GraphLibary2 libary2 = new GraphLibary2();

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        libary2.drawLine(x1, x2, y1, y2);
    }

    @Override
    public void drawCircle(int x, int y, int r) {
        libary2.drawCircle(x, y, r);
    }
}
