package cn.chuxiao.designpattern.bridge;

/**
 * 维度1:Drawing
 */
public interface Drawing {
    void drawLine(int x1, int y1, int x2, int y2);

    void drawCircle(int x, int y, int r);
}
