package code.chapter15.abstractfactory7;

/**
 * @author MYXH
 * @date 2023/4/15
 */

public class CashNormal implements ISale {
    //正常收费，原价返回
    public double acceptCash(double price,int num){
        return price * num; 
    }    
}