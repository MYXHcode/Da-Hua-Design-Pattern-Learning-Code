package code.chapter2.strategy4;

/**
 * @author MYXH
 * @date 2023/4/3
 */

public class CashContext {

    private CashSuper cs;   //声明一个CashSuper对象

    //通过构造方法，传入具体的收费策略
    public CashContext(CashSuper csuper){
        this.cs = csuper;
    }

    public double getResult(double price,int num){
        //根据收费策略的不同，获得计算结果
        return this.cs.acceptCash(price,num);
    }    
}