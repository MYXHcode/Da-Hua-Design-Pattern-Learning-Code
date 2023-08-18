package code.chapter20.iterator1;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/20
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        ConcreteAggregate bus = new ConcreteAggregate();
        bus.add("大鸟");
        bus.add("小菜");
        bus.add("行李");
        bus.add("老外");
        bus.add("公交内部员工");
        bus.add("小偷");

        //正序迭代器
        //Iterator conductor = new ConcreteIterator(bus);
        //倒序迭代器
        Iterator conductor = new ConcreteIteratorDesc(bus);

        conductor.first();
        while (!conductor.isDone()) {
            System.out.println(conductor.currentItem() + "，请买车票!");
            conductor.next();
        }

        System.out.println();
        System.out.println("**********************************************");

    }
}

//聚集抽象类
abstract class Aggregate {
    //创建迭代器
    public abstract Iterator createIterator();
}

//具体聚集类，继承Aggregate
class ConcreteAggregate extends Aggregate {

    //声明一个ArrayList泛型变量，用于存放聚合对象
    private ArrayList<Object> items = new ArrayList<Object>();

    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    //返回聚集总个数
    public int getCount() {
        return items.size();
    }

    //增加新对象
    public void add(Object object) {
        items.add(object);
    }

    //得到指定索引对象
    public Object getCurrentItem(int index) {
        return items.get(index);
    }

}

//迭代器抽象类
abstract class Iterator {

    public abstract Object first();         //第一个

    public abstract Object next();          //下一个

    public abstract boolean isDone();       //是否到最后

    public abstract Object currentItem();   //当前对象

}

//具体迭代器类，继承Iterator
class ConcreteIterator extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    //初始化时将具体的聚集对象传入
    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    //得到第一个对象
    public Object first() {
        return aggregate.getCurrentItem(0);
    }

    //得到下一个对象
    public Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.getCount()) {
            ret = aggregate.getCurrentItem(current);
        }
        return ret;
    }

    //判断当前是否遍历到结尾，到结尾返回true
    public boolean isDone() {
        return current >= aggregate.getCount() ? true : false;
    }

    //返回当前的聚集对象
    public Object currentItem() {
        return aggregate.getCurrentItem(current);
    }
}

//具体迭代器类(倒序），继承Iterator
class ConcreteIteratorDesc extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIteratorDesc(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
        current = aggregate.getCount() - 1;
    }

    //第一个对象
    public Object first() {
        return aggregate.getCurrentItem(aggregate.getCount() - 1);
    }

    //下一个对象
    public Object next() {
        Object ret = null;
        current--;
        if (current >= 0) {
            ret = aggregate.getCurrentItem(current);
        }
        return ret;
    }

    //判断当前是否遍历到结尾，到结尾返回true
    public boolean isDone() {
        return current < 0 ? true : false;
    }

    //返回当前的聚集对象
    public Object currentItem() {
        return aggregate.getCurrentItem(current);
    }
}