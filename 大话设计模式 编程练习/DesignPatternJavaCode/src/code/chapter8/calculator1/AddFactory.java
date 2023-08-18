package code.chapter8.calculator1;

/**
 * @author MYXH
 * @date 2023/4/8
 */

//加法工厂
public class AddFactory implements IFactory {

    public Operation createOperation(){
        return new Add();
    }
    
}