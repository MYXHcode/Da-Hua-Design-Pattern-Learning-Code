package code.chapter22.bridge0;

/**
 * @author MYXH
 * @date 2023/4/22
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println();       

        Abstraction ab;
        ab = new RefinedAbstraction();

        ab.setImplementor(new ConcreteImplementorA());
        ab.operation();

        ab.setImplementor(new ConcreteImplementorB());
        ab.operation();

        System.out.println();
        System.out.println("**********************************************");
    }
}

abstract class Implementor{
    public abstract void operation();
}


class ConcreteImplementorA extends Implementor{
    public void operation(){
        System.out.println("具体实现A的方法执行");
    }
}

class ConcreteImplementorB extends Implementor{
    public void operation(){
        System.out.println("具体实现B的方法执行");
    }
}


abstract class Abstraction{
    protected Implementor implementor;

    public void setImplementor(Implementor implementor){
        this.implementor = implementor;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction{
    public void operation(){
        System.out.print("具体的Abstraction");
        implementor.operation();
    }
}