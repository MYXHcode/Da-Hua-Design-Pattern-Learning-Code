package code.chapter15.abstractfactory6;

import java.lang.reflect.InvocationTargetException;  

//与读文件内容相关的包 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author MYXH
 * @date 2023/4/15
 */

public class DataAccess {

    private static String assemblyName = "code.chapter15.abstractfactory6.";
    
    public static String getDb() {
        String result="";
        try{
            Properties properties = new Properties();
            //编译后，请将db.properties文件复制到要编译的class目录中,并确保下面path路径与
            //实际db.properties文件路径一致。否则会报No such file or directory错误
            String path=System.getProperty("user.dir")+"/code/chapter15/abstractfactory6/db.properties";
            System.out.println("path:"+path);            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            properties.load(bufferedReader);
            result = properties.getProperty("db");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    //创建用户对象工厂
    public static IUser createUser() {
        String db=getDb();
        return (IUser)getInstance(assemblyName + db + "User");
    }

    //创建部门对象工厂
    public static IDepartment createDepartment(){
        String db=getDb();
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