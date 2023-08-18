package code.chapter23.command0;

/**
 * @author MYXH
 * @date 2023/4/23
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();

        invoker.setCommand(command);
        invoker.executeCommand();

        
        System.out.println();
        System.out.println("**********************************************");
    }
}

//抽象命令类
abstract class Command {
    protected Receiver receiver;

    public Command(Receiver receiver){
        this.receiver = receiver;
    }
    //执行命令
    public abstract void excuteCommand();
}

//具体命令类
class ConcreteCommand extends Command{
    public ConcreteCommand(Receiver receiver){
        super(receiver);
    }

    public void excuteCommand(){
        receiver.action();
    }
}

class Invoker{

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void executeCommand(){
        command.excuteCommand();
    }

}

class Receiver{
    public void action(){
        System.out.println("执行请求！");
    }
}