package code.chapter26.flyweight1;

/**
 * @author MYXH
 * @date 2023/4/26
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        WebSite fx = new WebSite("产品展示");
        fx.use();

        WebSite fy = new WebSite("产品展示");
        fy.use();

        WebSite fz = new WebSite("产品展示");
        fz.use();

        WebSite fl = new WebSite("博客");
        fl.use();

        WebSite fm = new WebSite("博客");
        fm.use();

        WebSite fn = new WebSite("博客");
        fn.use();


        System.out.println();
        System.out.println("**********************************************");
    }
}

//网站
class WebSite {
    private String name = "";
    public WebSite(String name) {
        this.name = name;
    }
    public void use() {
        System.out.println("网站分类：" + name);
    }
}