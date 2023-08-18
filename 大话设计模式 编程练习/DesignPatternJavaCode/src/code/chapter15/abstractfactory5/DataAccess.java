package code.chapter15.abstractfactory5;

import java.lang.reflect.InvocationTargetException;

/**
 * @author MYXH
 * @date 2023/4/15
 */

public class DataAccess {
    private static String assemblyName = "code.chapter15.abstractfactory5.";
    private static String db ="Sqlserver";//数据库名称，可替换成Access

    //创建用户对象工厂
    public static IUser createUser() {
        return (IUser)getInstance(assemblyName + db + "User");
    }
    //创建部门对象工厂
    public static IDepartment createDepartment(){
        return (IDepartment)getInstance(assemblyName + db + "Department");
    }
    private static Object getInstance(String className){
        Object result = null;
        try{
            result = Class.forName(className).getDeclaredConstructor().newInstance();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}