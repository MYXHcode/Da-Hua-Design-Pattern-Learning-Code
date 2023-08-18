package code.chapter14.observer3;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/14
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        //老板胡汉三
        Subject boss1 = new Boss("胡汉三");

        //看股票的同事
        Observer employee1 = new StockObserver("魏关姹", boss1);
        Observer employee2 = new StockObserver("易管查", boss1);
        //看NBA的同事
        Observer employee3 = new NBAObserver("兰秋幂", boss1);

        //老板登记下三个同事
        boss1.attach(employee1);
        boss1.attach(employee2);
        boss1.attach(employee3);

        boss1.detach(employee1); //魏关姹其实没有被通知到，所有减去

        //老板回来
        boss1.setAction("我胡汉三回来了");
        //通知两个同事
        boss1.notifyEmployee();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//通知者接口
abstract class Subject {
    protected String name;

    public Subject(String name) {
        this.name = name;
    }

    //同事列表
    private ArrayList<Observer> list = new ArrayList<Observer>();//针对抽象的Observer编程
    private String action;

    //增加同事（有几个同事需要秘书通知，就增加几个对象）
    public void attach(Observer observer) {
        list.add(observer);
    }

    //减少同事
    public void detach(Observer observer) {
        list.remove(observer);
    }

    //通知
    public void notifyEmployee() {
        //给所有登记过的同事发通知
        for (Observer item : list) {
            item.update();
        }
    }

    //得到状态
    public String getAction() {
        return this.action;
    }

    //设置状态（就是设置具体通知的话）
    public void setAction(String value) {
        this.action = value;
    }
}

//老板
class Boss extends Subject {
    public Boss(String name) {
        super(name);
    }

    //拥有自己的方法和属性
}

//前台类
class Secretary extends Subject {
    public Secretary(String name) {
        super(name);
    }

    //拥有自己的方法和属性
}

//抽象观察者
abstract class Observer {
    protected String name;
    protected Subject sub;

    public Observer(String name, Subject sub) {
        this.name = name;
        this.sub = sub;
    }

    public abstract void update();
}

//看股票同事类
class StockObserver extends Observer {
    public StockObserver(String name, Subject sub) {
        super(name, sub);
    }

    public void update() {
        System.out.println(super.sub.name + "：" + super.sub.getAction() + "！" + super.name + "，请关闭股票行情，赶紧工作。");
    }
}

//看NBA同事类
class NBAObserver extends Observer {
    public NBAObserver(String name, Subject sub) {
        super(name, sub);
    }

    public void update() {
        System.out.println(super.sub.name + "：" + super.sub.getAction() + "！" + super.name + "，请关闭NBA直播，赶紧工作。");
    }
}