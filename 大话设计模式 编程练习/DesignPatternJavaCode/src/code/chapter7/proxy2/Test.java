package code.chapter7.proxy2;

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

//代理类
class Proxy {
    private SchoolGirl mm;

    public Proxy(SchoolGirl mm) {
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

//被追求者类
class SchoolGirl {
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }
}