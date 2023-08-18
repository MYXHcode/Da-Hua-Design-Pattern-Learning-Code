package code.chapter15.abstractfactory2;

/**
 * @author MYXH
 * @date 2023/4/15
 */

//Sqlserver工厂
public class SqlserverFactory implements IFactory {

    public IUser createUser(){
        return new SqlserverUser();
    }
    
}