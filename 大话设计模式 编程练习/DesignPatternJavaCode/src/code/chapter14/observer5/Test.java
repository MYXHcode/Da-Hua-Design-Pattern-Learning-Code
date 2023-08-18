package code.chapter14.observer5;

import java.util.Observable;
import java.util.Observer;

/**
 * @author MYXH
 * @date 2023/4/14
 */

// //jdk中Observer代码
// public interface Observer {
//     void update(Observable o, Object arg);
// }

// //jdk中Observable代码
// public class Observable {
//     private boolean changed = false;
//     private Vector obs;
//     public Observable() {
//         obs = new Vector();
//     }
//     public synchronized void addObserver(Observer o) {
//         if (o == null)
//             throw new NullPointerException();
//         if (!obs.contains(o)) {
//             obs.addElement(o);
//         }
//     }
//     public synchronized void deleteObserver(Observer o) {
//         obs.removeElement(o);
//     }
//     public void notifyObservers() {
//         notifyObservers(null);
//     }
//     public void notifyObservers(Object arg) {
//         Object[] arrLocal;

//         synchronized (this) {
//             if (!changed)
//                 return;
//             arrLocal = obs.toArray();
//             clearChanged();
//         }

//         for (int i = arrLocal.length-1; i>=0; i--)
//             ((Observer)arrLocal[i]).update(this, arg);
//     }
//     public synchronized void deleteObservers() {
//         obs.removeAllElements();
//     }
//     protected synchronized void setChanged() {
//         changed = true;
//     }
//     protected synchronized void clearChanged() {
//         changed = false;
//     }
//     public synchronized boolean hasChanged() {
//         return changed;
//     }
//     public synchronized int countObservers() {
//         return obs.size();
//     }
// }

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        //老板胡汉三
        Boss boss1 = new Boss("胡汉三");

        //看股票的同事
        Observer employee1 = new StockObserver("魏关姹");
        Observer employee2 = new StockObserver("易管查");
        Observer employee3 = new NBAObserver("兰秋幂");

        //老板登记下三个同事
        boss1.addObserver(employee1);
        boss1.addObserver(employee2);
        boss1.addObserver(employee3);

        boss1.deleteObserver(employee1); //魏关姹其实没有被通知到，所有减去


        //老板回来
        boss1.setAction("我胡汉三回来了");

        System.out.println();
        System.out.println("**********************************************");

    }
}

//Subject
class Subject extends Observable {
    protected String name;
    private String action;

    public Subject(String name) {
        this.name = name;
    }

    //得到状态
    public String getAction() {
        return this.action;
    }

    //设置状态（就是设置具体通知的话）
    public void setAction(String value) {
        this.action = value;
        setChanged();
        notifyObservers();
    }
}

//老板
class Boss extends Subject {
    public Boss(String name) {
        super(name);
    }
}


//看股票同事类
class StockObserver implements Observer {
    protected String name;

    public StockObserver(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {

        Subject b = (Subject) o;

        System.out.println(b.name + "：" + b.getAction() + "！" + this.name + "，请关闭股票行情，赶紧工作。");
    }
}


//看NBA同事类
class NBAObserver implements Observer {
    protected String name;

    public NBAObserver(String name) {
        this.name = name;
    }

    public void update(Observable o, Object arg) {
        Subject b = (Subject) o;
        System.out.println(b.name + "：" + b.getAction() + "！" + this.name + "，请关闭NBA直播，赶紧工作。");
    }
}