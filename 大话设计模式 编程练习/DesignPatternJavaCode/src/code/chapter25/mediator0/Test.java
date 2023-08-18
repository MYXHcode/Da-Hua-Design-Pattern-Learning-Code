package code.chapter25.mediator0;

/**
 * @author MYXH
 * @date 2023/4/25
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        c1.send("吃过饭了吗?");
        c2.send("没有呢，你打算请客？");


        System.out.println();
        System.out.println("**********************************************");
    }
}

//中介者类
abstract class Mediator {
    //定义一个抽象的发送消息方法，得到同事对象和发送信息
    public abstract void send(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;

    //构造方法，得到中介者对象
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}

class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        this.mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事1得到信息:" + message);
    }
}

class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        this.mediator.send(message, this);
    }

    public void notify(String message) {
        System.out.println("同事2得到信息:" + message);
    }
}

class ConcreteMediator extends Mediator {
    private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;

    public void setColleague1(ConcreteColleague1 value) {
        this.colleague1 = value;
    }

    public void setColleague2(ConcreteColleague2 value) {
        this.colleague2 = value;
    }

    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.notify(message);
        } else {
            colleague1.notify(message);
        }
    }
}