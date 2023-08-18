package code.chapter18.memento0;

/**
 * @author MYXH
 * @date 2023/4/18
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        //Originator初始状态，状态属性为"On"
        Originator o = new Originator();
        o.setState("On");
        o.show();

        Caretaker c = new Caretaker();
        //保存状态时，由于有了很好的封装，可以隐藏Originator的实现细节
        c.setMemento(o.createMemento());

        //Originator改变了状态属性为"Off"
        o.setState("Off");
        o.show();

        //恢复原初始状态
        o.recoveryMemento(c.getMemento());
        o.show();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//发起人类
class Originator {

    //状态
    private String state;

    public String getState() {
        return this.state;
    }

    public void setState(String value) {
        this.state = value;
    }

    //显示数据
    public void show() {
        System.out.println("State:" + this.state);
    }

    //创建备忘录
    public Memento createMemento() {
        return new Memento(this.state);
    }

    //恢复备忘录
    public void recoveryMemento(Memento memento) {
        this.setState(memento.getState());
    }

}

//备忘录类
class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String value) {
        this.state = value;
    }
}

//管理者
class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return this.memento;
    }

    public void setMemento(Memento value) {
        this.memento = value;
    }
}