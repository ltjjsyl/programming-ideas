package cn.chuxiao.designprinciple.lsp.example2;

public class Rectangle {

    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int area() {
        return this.height * this.width;
    }
}
