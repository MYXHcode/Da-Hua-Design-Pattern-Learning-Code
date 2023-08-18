package code.chapter14.observer1;

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
        StockObserver employee1 = new StockObserver("魏关姹", secretary1);
        StockObserver employee2 = new StockObserver("易管查", secretary1);

        //前台登记下两伴同事
        secretary1.attach(employee1);
        secretary1.attach(employee2);

        //当发现老板回来了时
        secretary1.setAction("老板回来了");
        //通知两个同事
        secretary1.notifyEmployee();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//前台秘书类
class Secretary {
    protected String name;

    public Secretary(String name) {
        this.name = name;
    }

    //同事列表
    private ArrayList<StockObserver> list = new ArrayList<StockObserver>();
    private String action;

    //增加同事（有几个同事需要前台通知，就增加几个对象）
    public void attach(StockObserver observer) {
        list.add(observer);
    }

    //通知
    public void notifyEmployee() {
        //待老板来了，就给所有登记过的同事发通知
        for (StockObserver item : list) {
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

//看股票同事类
class StockObserver {
    private String name;
    private Secretary sub;

    public StockObserver(String name, Secretary sub) {
        this.name = name;
        this.sub = sub;
    }

    public void update() {
        System.out.println(this.sub.name + "：" + this.sub.getAction() + "！" + this.name + "，请关闭股票行情，赶紧工作。");
    }
}