package code.chapter7.proxy3;

/**
 * @author MYXH
 * @date 2023/4/7
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        SchoolGirl girlLjj = new SchoolGirl();
        girlLjj.setName("李娇娇");

        Proxy boyDl = new Proxy(girlLjj);
        boyDl.giveDolls();
        boyDl.giveFlowers();
        boyDl.giveChocolate();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//送礼物接口
interface IGiveGift {
    void giveDolls();

    void giveFlowers();

    void giveChocolate();
}

//追求者类
class Pursuit implements IGiveGift {

    private SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    public void giveDolls() {
        System.out.println(this.mm.getName() + ",你好！送你洋娃娃。");
    }

    public void giveFlowers() {
        System.out.println(this.mm.getName() + ",你好！送你鲜花。");
    }

    public void giveChocolate() {
        System.out.println(this.mm.getName() + ",你好！送你巧克力。");
    }
}

//代理类
class Proxy implements IGiveGift {

    private Pursuit gg;                //认识追求者

    public Proxy(SchoolGirl mm) {    //也认识被追求者
        this.gg = new Pursuit(mm);    //代理初始化的过程，实际是追求者初始化的过程
    }

    public void giveDolls() {        //代理在送礼物
        this.gg.giveDolls();        //实质是追求者在送礼物
    }

    public void giveFlowers() {
        this.gg.giveFlowers();
    }

    public void giveChocolate() {
        this.gg.giveChocolate();
    }
}

class SchoolGirl {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }
}