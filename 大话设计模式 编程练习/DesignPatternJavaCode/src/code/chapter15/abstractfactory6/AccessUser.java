package code.chapter15.abstractfactory6;

/**
 * @author MYXH
 * @date 2023/4/15
 */

public class AccessUser implements IUser {

    //新增一个用户
    public void insert(User user){
        System.out.println("在Access中给User表增加一条记录");     
    }

    //获取一个用户信息
    public User getUser(int id){
        System.out.println("在Access中根据用户ID得到User表一条记录");   
        return null;  
    }

}