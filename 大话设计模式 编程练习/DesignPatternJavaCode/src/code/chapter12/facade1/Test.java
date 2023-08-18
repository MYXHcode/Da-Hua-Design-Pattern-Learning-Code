package code.chapter12.facade1;

/**
 * @author MYXH
 * @date 2023/4/12
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Stock1 stock1 = new Stock1();
        Stock2 stock2 = new Stock2();
        NationalDebt1 nd1 = new NationalDebt1();
        Realty1 rt1 = new Realty1();

        stock1.buy();
        stock2.buy();
        nd1.buy();
        rt1.buy();

        stock1.sell();
        stock2.sell();
        nd1.sell();
        rt1.sell();


        System.out.println();
        System.out.println("**********************************************");

    }
}

//股票1
class Stock1 {
    //卖股票
    public void sell() {
        System.out.println("股票1卖出");
    }

    //买股票
    public void buy() {
        System.out.println("股票1买入");
    }
}

//股票2
class Stock2 {
    //卖股票
    public void sell() {
        System.out.println("股票2卖出");
    }

    //买股票
    public void buy() {
        System.out.println("股票2买入");
    }
}

//国债1
class NationalDebt1 {
    //卖国债
    public void sell() {
        System.out.println("国债1卖出");
    }

    //买国债
    public void buy() {
        System.out.println("国债1买入");
    }
}

//房地产1
class Realty1 {
    //卖房地产
    public void sell() {
        System.out.println("房地产1卖出");
    }

    //买房地产
    public void buy() {
        System.out.println("房地产1买入");
    }
}