package code.chapter26.flyweight0;

import java.util.Hashtable;

/**
 * @author MYXH
 * @date 2023/4/26
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        int extrinsicstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweight("X");
        fx.operation(--extrinsicstate);

        Flyweight fy = f.getFlyweight("Y");
        fy.operation(--extrinsicstate);

        Flyweight fz = f.getFlyweight("Z");
        fz.operation(--extrinsicstate);

        Flyweight uf = new UnsharedConcreteFlyweight();

        uf.operation(--extrinsicstate);

        System.out.println();
        System.out.println("**********************************************");
    }
}


abstract class Flyweight {
    public abstract void operation(int extrinsicstate);
}

//需要共享的具体Flyweight子类
class ConcreteFlyweight extends Flyweight {
    public void operation(int extrinsicstate) {
        System.out.println("具体Flyweight:" + extrinsicstate);
    }
}

//不需要共享的Flyweight子类
class UnsharedConcreteFlyweight extends Flyweight {
    public void operation(int extrinsicstate) {
        System.out.println("不共享的具体Flyweight:" + extrinsicstate);
    }
}

//享元工厂
class FlyweightFactory {
    private Hashtable<String, Flyweight> flyweights = new Hashtable<String, Flyweight>();

    public FlyweightFactory() {
        flyweights.put("X", new ConcreteFlyweight());
        flyweights.put("Y", new ConcreteFlyweight());
        flyweights.put("Z", new ConcreteFlyweight());
    }

    public Flyweight getFlyweight(String key) {
        return (Flyweight) flyweights.get(key);
    }
}