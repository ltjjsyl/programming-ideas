package visitor.dispatch;

public class SingleDispatchClassV2 {
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ChildClass c) {
        c.f();
    }
}
