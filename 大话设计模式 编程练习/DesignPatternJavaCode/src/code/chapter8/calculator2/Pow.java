package code.chapter8.calculator2;

/**
 * @author MYXH
 * @date 2023/4/8
 */

//指数运算类，求numberA的numberB次方
public class Pow extends Operation {

    public double getResult(double numberA, double numberB){
        //此处缺两参数的有效性检测
        return Math.pow(numberA,numberB);
    }
    
}