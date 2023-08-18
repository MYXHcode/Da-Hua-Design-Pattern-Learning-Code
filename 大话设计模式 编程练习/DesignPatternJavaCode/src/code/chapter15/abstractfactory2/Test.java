package code.chapter15.abstractfactory2;

/**
 * @author MYXH
 * @date 2023/4/15
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        User user = new User();

        IFactory factory = new SqlserverFactory();

        IUser iu = factory.createUser();

        iu.insert(user);    //新增一个用户
        iu.getUser(1);      //得到用户ID为1的用户信息

        IFactory factory2 = new AccessFactory();
        IUser iu2 = factory2.createUser();

        iu2.insert(user);    //新增一个用户
        iu2.getUser(1);      //得到用户ID为1的用户信息

        System.out.println();
        System.out.println("**********************************************");

    }
}