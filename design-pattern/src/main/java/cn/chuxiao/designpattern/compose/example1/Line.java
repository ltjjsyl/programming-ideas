package cn.chuxiao.designpattern.compose.example1;

public class Line implements Shape {

    @Override
    public void draw() {
        System.out.println("I'm a line.");
    }
}
