package code.chapter23.command1;

/**
 * @author MYXH
 * @date 2023/4/23
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Barbecuer boy = new Barbecuer();

        boy.bakeMutton();
        boy.bakeMutton();
        boy.bakeMutton();
        boy.bakeChickenWing();
        boy.bakeMutton();
        boy.bakeMutton();
        boy.bakeChickenWing();

        System.out.println();
        System.out.println("**********************************************");
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