package code.chapter23.command2;

/**
 * @author MYXH
 * @date 2023/4/23
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        //开店前的准备
        Barbecuer boy = new Barbecuer();//烤肉厨师
        Command bakeMuttonCommand1 = new BakeMuttonCommand(boy);            //烤羊肉串
        Command bakeChickenWingCommand1 = new BakeChickenWingCommand(boy);  //烤鸡翅
        Waiter girl = new Waiter();     //服务员

        //开门营业
        girl.setOrder(bakeMuttonCommand1);      //下单烤羊肉串
        girl.notifyCommand();                   //通知厨师烤肉
        girl.setOrder(bakeMuttonCommand1);      //下单烤羊肉串
        girl.notifyCommand();                   //通知厨师烤肉
        girl.setOrder(bakeChickenWingCommand1); //下单烤鸡翅
        girl.notifyCommand();                   //通知厨师烤肉

        System.out.println();
        System.out.println("**********************************************");
    }
}

//抽象命令类
abstract class Command {
    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    //执行命令
    public abstract void excuteCommand();
}

//烤羊肉命令类
class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    public void excuteCommand() {
        receiver.bakeMutton();
    }
}

//烤鸡翅命令类
class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    public void excuteCommand() {
        receiver.bakeChickenWing();
    }
}

//服务员类
class Waiter {
    private Command command;

    //设置订单
    public void setOrder(Command command) {
        this.command = command;
    }

    //通知执行
    public void notifyCommand() {
        command.excuteCommand();
    }
}


//烤肉串者
class Barbecuer {
    //烤羊肉
    public void bakeMutton() {
        System.out.println("烤羊肉串！");
    }

    //烤鸡翅
    public void bakeChickenWing() {
        System.out.println("烤鸡翅！");
    }
}