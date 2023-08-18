package code.chapter10.templatemethod0;

/**
 * @author MYXH
 * @date 2023/4/10
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        AbstractClass classA = new ConcreteClassA();
        classA.templateMethod();
        AbstractClass classB = new ConcreteClassB();
        classB.templateMethod();


        System.out.println();
        System.out.println("**********************************************");

    }
}

//模板方法抽象类
abstract class AbstractClass {
    //模板方法
    public void templateMethod() {

        //写一些可以被子类共享的代码

        this.primitiveOperation1();
        this.primitiveOperation2();
    }

    public abstract void primitiveOperation1(); //子类个性的行为，放到子类去实现

    public abstract void primitiveOperation2(); //子类个性的行为，放到子类去实现

}

//模板方法具体类A
class ConcreteClassA extends AbstractClass {
    public void primitiveOperation1() {
        System.out.println("具体类A方法1实现");
    }

    public void primitiveOperation2() {
        System.out.println("具体类A方法2实现");
    }
}

//模板方法具体类B
class ConcreteClassB extends AbstractClass {
    public void primitiveOperation1() {
        System.out.println("具体类B方法1实现");
    }

    public void primitiveOperation2() {
        System.out.println("具体类B方法2实现");
    }
}