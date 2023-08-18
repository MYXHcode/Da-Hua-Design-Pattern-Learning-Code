package code.chapter8.calculator1;

/**
 * @author MYXH
 * @date 2023/4/8
 */

//减法工厂
public class SubFactory implements IFactory {

    public Operation createOperation(){
        return new Sub();
    }
    
}