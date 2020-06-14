package cn.chuxiao.designpattern.bridge;

/**
 * 两个维度正交，易于扩展
 */
public class Main {
    public static void main(String[] args) {

        Drawing d1 = new DrawingByGL1();
        Drawing d2 = new DrawingByGL2();

        Shape r = new Rectangle(1, 2, 3, 4);
        r.setDrawing(d1);
        r.draw();
        System.out.println();
        r.setDrawing(d2);
        r.draw();
        System.out.println();

        Shape c = new Circle(2, 3, 4);
        c.setDrawing(d1);
        c.draw();
        System.out.println();
        c.setDrawing(d2);
        c.draw();
    }
}
