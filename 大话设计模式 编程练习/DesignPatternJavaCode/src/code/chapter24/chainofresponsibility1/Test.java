package code.chapter24.chainofresponsibility1;

/**
 * @author MYXH
 * @date 2023/4/24
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Manager manager = new Manager("金利");
        Manager director = new Manager("宗剑");
        Manager generalManager = new Manager("钟精励");

        Request request = new Request();
        request.setRequestType("加薪");
        request.setRequestContent("小菜请求加薪");
        request.setNumber(10000);

        manager.getResult("经理", request);
        director.getResult("总监", request);
        generalManager.getResult("总经理", request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小菜请假");
        request2.setNumber(3);

        manager.getResult("经理", request2);
        director.getResult("总监", request2);
        generalManager.getResult("总经理", request2);

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

//管理者
class Manager {
    protected String name;

    public Manager(String name) {
        this.name = name;
    }

    public void getResult(String managerLevel, Request request) {
        if (managerLevel == "经理") {
            if (request.getRequestType() == "请假" && request.getNumber() <= 2)
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "天，被批准");
            else
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "天，我无权处理");
        } else if (managerLevel == "总监") {
            if (request.getRequestType() == "请假" && request.getNumber() <= 5)
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "天，被批准");
            else
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "天，我无权处理");
        } else if (managerLevel == "总经理") {
            if (request.getRequestType() == "请假")
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "天，被批准");
            else if (request.getRequestType() == "加薪" && request.getNumber() <= 5000)
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "元，被批准");
            else if (request.getRequestType() == "加薪" && request.getNumber() > 5000)
                System.out.println(this.name + ":" + request.getRequestContent() + " 数量:" + request.getNumber() + "元，再说吧");
        }
    }
}