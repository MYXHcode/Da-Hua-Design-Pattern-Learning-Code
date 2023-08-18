package code.chapter12.facade2;

/**
 * @author MYXH
 * @date 2023/4/12
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Fund fund1 = new Fund();
        //基金购买
        fund1.buyFund();
        //基金赎回
        fund1.sellFund();


        System.out.println();
        System.out.println("**********************************************");

    }
}

//基金类
class Fund {
    Stock1 stock1;
    Stock2 stock2;
    NationalDebt1 nd1;
    Realty1 rt1;

    public Fund() {
        stock1 = new Stock1();
        stock2 = new Stock2();
        nd1 = new NationalDebt1();
        rt1 = new Realty1();
    }

    public void buyFund() {
        stock1.buy();
        stock2.buy();
        nd1.buy();
        rt1.buy();
    }

    public void sellFund() {
        stock1.sell();
        stock2.sell();
        nd1.sell();
        rt1.sell();
    }

    //基金很多买入卖出操作，持仓比例等，
    //无需提前告知客户
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