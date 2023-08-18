package code.chapter17.adapter2;

/**
 * @author MYXH
 * @date 2023/17
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Player forwards = new Forwards("巴蒂尔");
        forwards.attack();

        Player guards = new Guards("麦克格雷迪");
        guards.attack();

        Player center = new Translator("姚明");

        center.attack();
        center.defense();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//球员
abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();  //进攻

    public abstract void defense(); //防守
}

//前锋
class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    public void attack() {
        System.out.println("前锋 " + this.name + " 进攻");
    }

    public void defense() {
        System.out.println("前锋 " + this.name + " 防守");
    }
}

//中锋
class Center extends Player {
    public Center(String name) {
        super(name);
    }

    public void attack() {
        System.out.println("中锋 " + this.name + " 进攻");
    }

    public void defense() {
        System.out.println("中锋 " + this.name + " 防守");
    }
}

//后卫
class Guards extends Player {
    public Guards(String name) {
        super(name);
    }

    public void attack() {
        System.out.println("后卫 " + this.name + " 进攻");
    }

    public void defense() {
        System.out.println("后卫 " + this.name + " 防守");
    }
}

//外籍中锋
class ForeignCenter {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void 进攻() {
        System.out.println("外籍中锋 " + this.name + " 进攻");
    }

    public void 防守() {
        System.out.println("外籍中锋 " + this.name + " 防守");
    }
}

//翻译者类
class Translator extends Player {

    private ForeignCenter foreignCenter = new ForeignCenter();

    public Translator(String name) {
        super(name);
        foreignCenter.setName(name);
    }

    public void attack() {
        foreignCenter.进攻();
    }

    public void defense() {
        foreignCenter.防守();
    }
}