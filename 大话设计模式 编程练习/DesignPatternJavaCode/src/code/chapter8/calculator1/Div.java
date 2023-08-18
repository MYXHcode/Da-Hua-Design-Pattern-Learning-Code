package code.chapter8.calculator1;

/**
 * @author MYXH
 * @date 2023/4/8
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