package cn.chuxiao.designpattern.template;

public class Main {
    public static void main(String[] args) {
        AbstactTemplateClass template = new ConcreteClassA();

        template.templateMethod();
    }
}
