package code.chapter15.abstractfactory7;

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

public class CashContext {

    private static String assemblyName = "code.chapter15.abstractfactory7.";
    
    private ISale cs;   //声明一个ISale接口对象
    
    //通过构造方法，传入具体的收费策略
    public CashContext(int cashType){
        
        String[] config = getConfig(cashType).split(",");

        IFactory fs=getInstance(config[0],
                                Double.parseDouble(config[1]),
                                Double.parseDouble(config[2]),
                                Double.parseDouble(config[3]));

        this.cs = fs.createSalesModel();
    }

    //通过文件得到销售策略的配置文件
    private String getConfig(int number) {
        String result="";
        try{
            Properties properties = new Properties();
            String path=System.getProperty("user.dir")+"/code/chapter15/abstractfactory7/data.properties";
            System.out.println("path:"+path);            
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            properties.load(bufferedReader);
            result = properties.getProperty("strategy"+number);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    //根据配置文件获得相关的对象实例
    private IFactory getInstance(String className,double a,double b,double c){
        IFactory result = null;
        try{
            result = (IFactory)Class.forName(assemblyName+className)
                                    .getDeclaredConstructor(new Class[]{double.class,double.class,double.class})
                                    .newInstance(new Object[]{a,b,c});  
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


    public double getResult(double price,int num){
        //根据收费策略的不同，获得计算结果
        return this.cs.acceptCash(price,num);
    }    
}