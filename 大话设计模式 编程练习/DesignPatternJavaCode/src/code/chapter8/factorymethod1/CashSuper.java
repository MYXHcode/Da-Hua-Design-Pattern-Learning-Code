package code.chapter8.factorymethod1;

/**
 * @author MYXH
 * @date 2023/4/8
 */

public class CashSuper implements ISale {

    protected ISale component;

    //装饰对象
    public void decorate(ISale component) {
        this.component=component;
    }

    public double acceptCash(double price,int num){
        if (this.component != null){
            //若装饰对象存在，则执行装饰的算法运算
            return this.component.acceptCash(price,num);    
        }
        else 
            return 0d;
    }
    
}