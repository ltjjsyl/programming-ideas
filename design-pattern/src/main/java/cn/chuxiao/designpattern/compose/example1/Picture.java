package cn.chuxiao.designpattern.compose.example1;

import java.util.ArrayList;
import java.util.List;

public class Picture implements Shape {
    List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }
}
