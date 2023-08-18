package code.chapter26.flyweight2;

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
        fx.use();

        WebSite fy = f.getWebSiteCategory("产品展示");
        fy.use();

        WebSite fz = f.getWebSiteCategory("产品展示");
        fz.use();

        WebSite fl = f.getWebSiteCategory("博客");
        fl.use();

        WebSite fm = f.getWebSiteCategory("博客");
        fm.use();

        WebSite fn = f.getWebSiteCategory("博客");
        fn.use();

        System.out.println("网站分类总数为:"+f.getWebSiteCount()); //统计实例化个数，结果应该为2

        System.out.println();
        System.out.println("**********************************************");
    }
}

//抽象的网站类
abstract class WebSite{
    public abstract void use();
}

//具体网站类
class ConcreteWebSite extends WebSite {
    private String name = "";
    public ConcreteWebSite(String name) {
        this.name = name;
    }
    public void use() {
        System.out.println("网站分类：" + name);
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