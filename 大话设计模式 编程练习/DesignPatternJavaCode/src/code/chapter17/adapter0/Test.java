package code.chapter17.adapter0;

/**
 * @author MYXH
 * @date 2023/17
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Target target = new Adapter();

        target.request();


        System.out.println();
        System.out.println("**********************************************");

    }
}

//需要适配的类
class Adaptee {
    public void specificRequest() {
        System.out.println("特殊请求！");
    }
}

//客户期待的接口
class Target {
    public void request() {
        System.out.println("普通请求！");
    }
}

//适配器类
class Adapter extends Target {

    private Adaptee adaptee = new Adaptee(); //建立一个私有的Adaptee对象

    public void request() {          //这样就可以把表面上调用request()方法
        adaptee.specificRequest();  //变成实际调用specificRequest()
    }
}