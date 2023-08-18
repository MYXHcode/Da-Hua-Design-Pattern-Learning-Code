package code.chapter19.component0;

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

        Composite root = new Composite("root");
        root.add(new Leaf("Leaf A"));
        root.add(new Leaf("Leaf B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("Leaf XA"));
        comp.add(new Leaf("Leaf XB"));
        root.add(comp);

        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("Leaf XYA"));
        comp2.add(new Leaf("Leaf XYB"));
        comp.add(comp2);

        Leaf leaf = new Leaf("Leaf C");
        root.add(leaf);

        Leaf leaf2 = new Leaf("Leaf D");
        root.add(leaf2);
        root.remove(leaf2);

        root.display(1);


        System.out.println();
        System.out.println("**********************************************");

    }
}

abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);
}

class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    public void add(Component component) {
        System.out.println("Cannot add to a leaf.");
    }

    public void remove(Component component) {
        System.out.println("Cannot remove from a leaf.");
    }

    public void display(int depth) {
        //叶节点的具体显示方法，此处是显示其名称和级别
        for (var i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
    }
}

class Composite extends Component {
    private ArrayList<Component> children = new ArrayList<Component>();//一个子对象集合用来存储其下属的枝节点和叶节点

    public Composite(String name) {
        super(name);
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public void display(int depth) {
        //显示其枝节点名称
        for (var i = 0; i < depth; i++)
            System.out.print("-");
        System.out.println(name);
        //对其下级进行遍历
        for (Component item : children) {
            item.display(depth + 2);
        }
    }
}