package code.chapter8.calculator2;

/**
 * @author MYXH
 * @date 2023/4/8
 */

public interface IFactory {

    public Operation createOperation(String operType);
    
}