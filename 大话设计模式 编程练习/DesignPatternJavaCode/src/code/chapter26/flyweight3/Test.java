package code.chapter26.flyweight3;

import java.util.Hashtable;

/**
 * @author MYXH
 * @date 2023/4/26
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        WebSiteFactory f = new WebSiteFactory();

        WebSite fx = f.getWebSiteCategory("产品展示");
        fx.use(new User("小菜"));
        
        WebSite fy = f.getWebSiteCategory("产品展示");
        fy.use(new User("大鸟"));

        WebSite fz = f.getWebSiteCategory("产品展示");
        fz.use(new User("娇娇"));

        WebSite fl = f.getWebSiteCategory("博客");
        fl.use(new User("老顽童"));

        WebSite fm = f.getWebSiteCategory("博客");
        fm.use(new User("桃谷六仙"));

        WebSite fn = f.getWebSiteCategory("博客");
        fn.use(new User("南海鳄神"));

        System.out.println("网站分类总数为:"+f.getWebSiteCount());

        System.out.println();

        // String titleA = new String("大话设计模式");
        // String titleB = new String("大话设计模式");

        // System.out.println(" titleA==titleB:          "+(titleA == titleB));        //比较内存引用地址
        // System.out.println(" titleA.equals(titleB):   "+(titleA.equals(titleB)));   //比较字符串的值

        // String titleC = "大话设计模式";
        // String titleD = "大话设计模式";

        // System.out.println(" titleC==titleD:          "+(titleC == titleD));        //比较内存引用地址
        // System.out.println(" titleC.equals(titleD):   "+(titleC.equals(titleD)));   //比较字符串的值

        System.out.println();
        System.out.println("**********************************************");
    }
}

//用户
class User{
    private String name;
    public User(String value){
        this.name=value;
    }

    public String getName(){
        return this.name;
    }
}

//抽象的网站类
abstract class WebSite{

    public abstract void use(User user);
}

//具体网站类
class ConcreteWebSite extends WebSite {
    private String name = "";
    public ConcreteWebSite(String name) {
        this.name = name;
    }
    public void use(User user) {
        System.out.println("网站分类：" + name+" 用户："+user.getName());
    }
}

//网站工厂
class WebSiteFactory {
    private Hashtable<String,WebSite> flyweights = new Hashtable<String,WebSite>();

    //获得网站分类
    public WebSite getWebSiteCategory(String key)
    {
        if (!flyweights.contains(key))
            flyweights.put(key, new ConcreteWebSite(key));
        return (WebSite)flyweights.get(key);
    }

    //获得网站分类总数
    public int getWebSiteCount()
    {
        return flyweights.size();
    }
}