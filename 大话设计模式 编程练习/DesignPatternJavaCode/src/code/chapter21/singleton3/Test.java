package code.chapter21.singleton3;

/**
 * @author MYXH
 * @date 2023/4/21
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        if (s1 == s2) {
            System.out.println("两个对象是相同的实例。");
        }

        System.out.println();
        System.out.println("**********************************************");
    }
}

//单例模式类
class Singleton {

    private static Singleton instance = new Singleton();

    //构造方法private化
    private Singleton() {
    }

    //得到Singleton的实例（唯一途径）
    public static Singleton getInstance() {
        return instance;
    }
}