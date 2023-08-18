package code.chapter1.calculator4;

/**
 * @author MYXH
 * @date 2023/4/2
 */

public class Div extends Operation {
    public double getResult(double numberA, double numberB){
        if (numberB == 0){
            System.out.println("除数不能为0");
            throw new ArithmeticException();
        }
        return numberA / numberB;
    }
}