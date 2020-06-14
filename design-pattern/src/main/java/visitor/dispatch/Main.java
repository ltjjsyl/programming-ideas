package visitor.dispatch;

public class Main {

    public static void main(String[] args) {
        SingleDispatchClassV1 demo1 = new SingleDispatchClassV1();
        ParentClass p1 = new ChildClass();
        demo1.polymorphismFunction(p1);//执行哪个对象的方法，由对象的实际类型决定
        demo1.overloadFunction(p1);//执行对象的哪个方法，由参数对象的声明类型决定

        System.out.println("=============================");
        SingleDispatchClassV2 demo2 = new SingleDispatchClassV2();
        ParentClass p2 = new ChildClass();
        demo2.polymorphismFunction(p2);//执行哪个对象的方法，由对象的实际类型决定
        demo2.overloadFunction(p2);//执行对象的哪个方法，由参数对象的声明类型决定，执行的具体结果由参数对象决定

    }
}
