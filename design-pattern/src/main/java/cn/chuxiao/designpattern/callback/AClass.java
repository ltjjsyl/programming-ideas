package cn.chuxiao.designpattern.callback;

public class AClass {

    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(() -> System.out.println("Call back me."));//回调对象
    }
}
