package cn.chuxiao.designpattern.compose.example1;

public class Text implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm a text.");
    }
}
