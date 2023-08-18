package code.chapter8.calculator1;

/**
 * @author MYXH
 * @date 2023/4/8
 */

//乘法工厂
public class MulFactory implements IFactory {

    public Operation createOperation(){
        return new Mul();
    }
    
}