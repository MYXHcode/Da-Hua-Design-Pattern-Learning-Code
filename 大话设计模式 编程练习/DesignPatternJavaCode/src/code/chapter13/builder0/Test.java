package code.chapter13.builder0;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/13
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Director director = new Director();
        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();

        //指挥者用ConcreteBuilder1的方法来建造产品
        director.construct(b1); //创建的是产品A和产品B
        Product p1 = b1.getResult();
        p1.show();

        //指挥者用ConcreteBuilder2的方法来建造产品
        director.construct(b2); //创建的是产品X和产品Y
        Product p2 = b2.getResult();
        p2.show();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//产品类
class Product {
    ArrayList<String> parts = new ArrayList<String>();

    //添加新的产品部件
    public void add(String part) {
        parts.add(part);
    }

    //列举所有产品部件
    public void show() {
        for (String part : parts) {
            System.out.println(part);
        }
    }
}

//抽象的建造者类
abstract class Builder {
    public abstract void buildPartA();      //建造部件A

    public abstract void buildPartB();      //建造部件B

    public abstract Product getResult();    //得到产品
}


//具体建造者1
class ConcreteBuilder1 extends Builder {
    private Product product = new Product();

    public void buildPartA() {
        product.add("部件A");
    }

    public void buildPartB() {
        product.add("部件B");
    }

    public Product getResult() {
        return product;
    }
}

//具体建造者2
class ConcreteBuilder2 extends Builder {
    private Product product = new Product();

    public void buildPartA() {
        product.add("部件X");
    }

    public void buildPartB() {
        product.add("部件Y");
    }

    public Product getResult() {
        return product;
    }
}


//指挥者
class Director {
    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}