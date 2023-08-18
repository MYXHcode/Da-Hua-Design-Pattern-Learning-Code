package code.chapter24.chainofresponsibility0;

/**
 * @author MYXH
 * @date 2023/4/24
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20};

        for (int request : requests) {
            h1.handleRequest(request);
        }

        System.out.println();
        System.out.println("**********************************************");
    }
}

abstract class Handler {
    protected Handler successor;

    //设置继任者
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}

class ConcreteHandler1 extends Handler {
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println(this.getClass().getSimpleName() + " 处理请求 " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler2 extends Handler {
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println(this.getClass().getSimpleName() + " 处理请求 " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler3 extends Handler {
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println(this.getClass().getSimpleName() + " 处理请求 " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}