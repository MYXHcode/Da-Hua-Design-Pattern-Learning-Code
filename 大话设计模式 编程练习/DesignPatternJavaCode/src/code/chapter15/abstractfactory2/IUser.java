package code.chapter15.abstractfactory2;

/**
 * @author MYXH
 * @date 2023/4/15
 */

//用户类接口
public interface IUser {

    public void insert(User user);

    public User getUser(int id);
}