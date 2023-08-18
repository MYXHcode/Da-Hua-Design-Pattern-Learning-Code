package code.chapter15.abstractfactory3;

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
        Department department = new Department();

        IFactory factory = new SqlserverFactory();
        //IFactory factory = new AccessFactory();

        IUser iu = factory.createUser();
        iu.insert(user);    //新增一个用户
        iu.getUser(1);      //得到用户ID为1的用户信息

        IDepartment idept = factory.createDepartment();
        idept.insert(department);    //新增一个部门
        idept.getDepartment(2);      //得到部门ID为2的用户信息


        System.out.println();
        System.out.println("**********************************************");

    }
}