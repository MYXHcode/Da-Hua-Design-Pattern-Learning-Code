package code.chapter14.observer2;

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

        //前台小姐童子喆
        Secretary secretary1 = new Secretary("童子喆");

        //看股票的同事
        Observer employee1 = new StockObserver("魏关姹", secretary1);
        Observer employee2 = new StockObserver("易管查", secretary1);
        //看NBA的同事
        Observer employee3 = new NBAObserver("兰秋幂", secretary1);

        //前台登记下三个同事
        secretary1.attach(employee1);
        secretary1.attach(employee2);
        secretary1.attach(employee3);

        //当发现老板回来了时
        secretary1.setAction("老板回来了");
        //通知三个同事
        secretary1.notifyEmployee();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//前台类
class Secretary {
    protected String name;

    public Secretary(String name) {
        this.name = name;
    }

    //同事列表
    private ArrayList<Observer> list = new ArrayList<Observer>();//针对抽象的Observer编程
    private String action;

    //增加同事（有几个同事需要前台通知，就增加几个对象）
    public void attach(Observer observer) {
        list.add(observer);
    }

    //减少同事
    public void detach(Observer observer) {
        list.remove(observer);
    }

    //通知
    public void notifyEmployee() {
        //待老板来了，就给所有登记过的同事发通知
        for (Observer item : list) {
            item.update();
        }
    }

    //得到前台状态
    public String getAction() {
        return this.action;
    }

    //设置前台状态（就是设置具体通知的话）
    public void setAction(String value) {
        this.action = value;
    }
}

//抽象观察者
abstract class Observer {
    protected String name;
    protected Secretary sub;

    public Observer(String name, Secretary sub) {
        this.name = name;
        this.sub = sub;
    }

    public abstract void update();
}

//看股票同事类
class StockObserver extends Observer {
    public StockObserver(String name, Secretary sub) {
        super(name, sub);
    }

    public void update() {
        System.out.println(super.sub.name + "：" + super.sub.getAction() + "！" + super.name + "，请关闭股票行情，赶紧工作。");
    }
}


//看NBA同事类
class NBAObserver extends Observer {
    public NBAObserver(String name, Secretary sub) {
        super(name, sub);
    }

    public void update() {
        System.out.println(super.sub.name + "：" + super.sub.getAction() + "！" + super.name + "，请关闭NBA直播，赶紧工作。");
    }
}