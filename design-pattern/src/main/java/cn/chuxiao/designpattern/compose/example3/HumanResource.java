package cn.chuxiao.designpattern.compose.example3;

/**
 * 在内存中构建整个公司的人员架构图（部门、子部门、员工的隶属关系），
 * 并且提供接口计算出部门的薪资成本（隶属于这个部门的所有员工的薪资和）。
 *
 * 部门包含子部门和员工，这是一种嵌套结构，可以表示成树这种数据结构。
 * 计算每个部门的薪资开支这样一个需求，也可以通过在树上的遍历算法来实现。
 * 所以，从这个角度来看，这 个应用场景可以使用组合模式来设计和实现。
 * 其中，HumanResource是部门类（Department）和员工类（Employee）抽象出来的父类，为的是能统一薪资的处理逻辑。
 * Demo中的代码负责从数据库中读取数据并在内存中构建组织架构图
 * */
public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
