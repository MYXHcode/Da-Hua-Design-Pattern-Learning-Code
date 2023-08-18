package code.chapter24.chainofresponsibility2;

/**
 * @author MYXH
 * @date 2023/4/24
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        CommonManager manager = new CommonManager("金利");
        Director director = new Director("宗剑");
        GeneralManager generalManager = new GeneralManager("钟精励");
        manager.setSuperior(director);
        director.setSuperior(generalManager);

        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("小菜请假");
        request.setNumber(1);
        manager.requestApplications(request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小菜请假");
        request2.setNumber(4);
        manager.requestApplications(request2);

        Request request3 = new Request();
        request3.setRequestType("加薪");
        request3.setRequestContent("小菜请求加薪");
        request3.setNumber(5000);
        manager.requestApplications(request3);

        Request request4 = new Request();
        request4.setRequestType("加薪");
        request4.setRequestContent("小菜请求加薪");
        request4.setNumber(10000);
        manager.requestApplications(request4);

        System.out.println();
        System.out.println("**********************************************");
    }
}

//申请
class Request {
    //申请类别
    private String requestType;

    public String getRequestType() {
        return this.requestType;
    }

    public void setRequestType(String value) {
        this.requestType = value;
    }

    //申请内容
    private String requestContent;

    public String getRequestContent() {
        return this.requestContent;
    }

    public void setRequestContent(String value) {
        this.requestContent = value;
    }

    //数量
    private int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int value) {
        this.number = value;
    }
}

//管理者抽象类
abstract class Manager {
    protected String name;

    public Manager(String name) {
        this.name = name;
    }

    //设置管理者上级
    protected Manager superior;

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    //请求申请
    public abstract void requestApplications(Request request);
}

//普通经理
class CommonManager extends Manager {
    public CommonManager(String name) {
        super(name);
    }

    public void requestApplications(Request request) {
        if (request.getRequestType() == "请假" && request.getNumber() <= 2)
            System.out.println(this.name + ":" + request.getRequestContent() + " 数量：" + request.getNumber() + "天，被批准");
        else {
            if (this.superior != null)
                this.superior.requestApplications(request);
        }
    }
}

//总监
class Director extends Manager {
    public Director(String name) {
        super(name);
    }

    public void requestApplications(Request request) {
        if (request.getRequestType() == "请假" && request.getNumber() <= 5)
            System.out.println(this.name + ":" + request.getRequestContent() + " 数量：" + request.getNumber() + "天，被批准");
        else {
            if (this.superior != null)
                this.superior.requestApplications(request);
        }
    }
}

//总经理
class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    public void requestApplications(Request request) {
        if (request.getRequestType() == "请假") {
            System.out.println(this.name + ":" + request.getRequestContent() + " 数量：" + request.getNumber() + "天，被批准");
        } else if (request.getRequestType() == "加薪" && request.getNumber() <= 5000) {
            System.out.println(this.name + ":" + request.getRequestContent() + " 数量：" + request.getNumber() + "元，被批准");
        } else if (request.getRequestType() == "加薪" && request.getNumber() > 5000) {
            System.out.println(this.name + ":" + request.getRequestContent() + " 数量：" + request.getNumber() + "元，再说吧");
        }
    }
}