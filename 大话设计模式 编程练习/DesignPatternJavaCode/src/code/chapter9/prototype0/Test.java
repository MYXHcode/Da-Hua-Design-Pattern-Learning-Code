package code.chapter9.prototype0;

/**
 * @author MYXH
 * @date 2023/4/9
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        ConcretePrototype p1 = new ConcretePrototype("编号123456");
        System.out.println("原ID:" + p1.getID());

        ConcretePrototype c1 = (ConcretePrototype) p1.clone();
        System.out.println("克隆ID:" + c1.getID());

        System.out.println();
        System.out.println("**********************************************");

    }
}

//原型类
abstract class Prototype implements Cloneable {
    private String id;

    public Prototype(String id) {
        this.id = id;
    }

    public String getID() {
        return this.id;
    }

    //原型模式的关键就是有这样一个clone方法
    public Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Clone异常。");
        }
        return object;
    }
}

//具体原型类
class ConcretePrototype extends Prototype {

    public ConcretePrototype(String id) {
        super(id);
    }

}