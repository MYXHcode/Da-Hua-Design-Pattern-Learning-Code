package code.chapter7.proxy0;

/**
 * @author MYXH
 * @date 2023/4/7
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();


        Proxy proxy = new Proxy();
        proxy.request();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//ISubject接口
interface ISubject {
    void request();
}

//RealSubject类
class RealSubject implements ISubject {

    public void request() {
        System.out.println("真实的请求。");
    }

}

//Proxy类
class Proxy implements ISubject {

    private RealSubject rs;

    public Proxy() {
        this.rs = new RealSubject();
    }

    public void request() {
        this.rs.request();
    }
}