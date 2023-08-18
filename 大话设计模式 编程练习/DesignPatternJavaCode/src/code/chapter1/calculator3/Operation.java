package code.chapter1.calculator3;

/**
 * @author MYXH
 * @date 2023/4/2
 */

public class Operation {
    public static double getResult(double numberA, 
        double numberB, String operate) {
        double result = 0d;
        switch (operate) {
            case "+":
                result = numberA + numberB;
                break;
            case "-":
                result = numberA - numberB;
                break;
            case "*":
                result = numberA * numberB;
                break;
            case "/":
                result = numberA / numberB;
                break;
            case "pow":
                result= Math.pow(numberA,numberB);
                break;
        }
        return result;
    }
}