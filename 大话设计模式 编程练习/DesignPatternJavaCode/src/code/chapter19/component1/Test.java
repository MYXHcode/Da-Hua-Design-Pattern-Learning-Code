package code.chapter19.component1;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/19
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany comp = new ConcreteCompany("上海华东分公司");
        comp.add(new HRDepartment("华东分公司人力资源部"));
        comp.add(new FinanceDepartment("华东分公司财务部"));
        root.add(comp);

        ConcreteCompany comp2 = new ConcreteCompany("南京办事处");
        comp2.add(new HRDepartment("南京办事处人力资源部"));
        comp2.add(new FinanceDepartment("南京办事处财务部"));
        comp.add(comp2);

        ConcreteCompany comp3 = new ConcreteCompany("杭州办事处");
        comp3.add(new HRDepartment("杭州办事处人力资源部"));
        comp3.add(new FinanceDepartment("杭州办事处财务部"));
        comp.add(comp3);

        System.out.println("结构图：");
        root.display(1);
        System.out.println("职责：");
        root.lineOfDuty();


        System.out.println();
        System.out.println("**********************************************");

    }
}

//公司抽象类
abstract class Company {
    protected String name;

    public Company(String name) {
        this.name = name;
    }

    public abstract void add(Company company);      //增加

    public abstract void remove(Company company);   //移除

    public abstract void display(int depth);        //显示

    public abstract void lineOfDuty();  //履行职责
}


//具体分公司类，树枝节点
class ConcreteCompany extends Company {
    protected ArrayList<Company> children = new ArrayList<Company>();

    public ConcreteCompany(String name) {
        super(name);
    }

    public void add(Company company) {
        children.add(company);
    }

    public void remove(Company company) {
        children.remove(company);
    }

    public void display(int depth) {
        for (var i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
        for (Company item : children) {
            item.display(depth + 2);
        }
    }

    //履行职责
    public void lineOfDuty() {
        for (Company item : children) {
            item.lineOfDuty();
        }
    }
}

//人力资源部，树叶节点
class HRDepartment extends Company {
    public HRDepartment(String name) {
        super(name);
    }

    public void add(Company company) {
    }

    public void remove(Company company) {
    }

    public void display(int depth) {
        for (var i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
    }

    //履行职责
    public void lineOfDuty() {
        System.out.println(name + " 员工招聘培训管理");
    }
}


//财务部，树叶节点
class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    public void add(Company company) {
    }

    public void remove(Company company) {
    }

    public void display(int depth) {
        for (var i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
    }

    //履行职责
    public void lineOfDuty() {
        System.out.println(name + " 公司财务收支管理");
    }
}