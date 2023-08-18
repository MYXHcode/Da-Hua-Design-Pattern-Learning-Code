package code.chapter8.calculator1;

/**
 * @author MYXH
 * @date 2023/4/8
 */

//除法工厂
public class DivFactory implements IFactory {

    public Operation createOperation(){
        return new Div();
    }
    
}