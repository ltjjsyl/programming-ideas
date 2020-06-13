package cn.chuxiao.designpattern.compose.example1;

public class Main {

    public static void main(String[] args) {
        Picture aPicture = new Picture();
        aPicture.add(new Line());
        aPicture.add(new Rectangle());

        Picture p = new Picture();
        p.add(new Line());
        p.add(new Rectangle());
        p.add(new Text());

        aPicture.add(p);

        aPicture.draw();
    }
}
