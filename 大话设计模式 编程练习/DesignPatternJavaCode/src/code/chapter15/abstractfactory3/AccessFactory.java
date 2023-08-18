package code.chapter15.abstractfactory3;

/**
 * @author MYXH
 * @date 2023/4/15
 */

//Access工厂
public class AccessFactory implements IFactory {

    public IUser createUser(){
        return new AccessUser();
    }

    public IDepartment createDepartment(){
        return new AccessDepartment();
    }

}