package cn.chuxiao.designprinciple.lsp.example2;

public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        setWidth(height);
    }
}
