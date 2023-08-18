package code.chapter6.decorator5;

/**
 * @author MYXH
 * @date 2023/4/7
 */

public class CashNormal implements ISale {
    //正常收费，原价返回
    public double acceptCash(double price,int num){
        return price * num; 
    }    
}