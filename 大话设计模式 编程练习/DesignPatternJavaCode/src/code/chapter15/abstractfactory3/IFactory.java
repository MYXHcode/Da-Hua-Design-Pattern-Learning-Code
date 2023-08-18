package code.chapter15.abstractfactory3;

/**
 * @author MYXH
 * @date 2023/4/15
 */

//工厂接口
public interface IFactory {

    public IUser createUser();

    public IDepartment createDepartment();
    
}