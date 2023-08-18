package code.chapter28.visitor2;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/28
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        ArrayList<Person> persons = new ArrayList<Person>();

        Person man1 = new Man();
        man1.setAction("成功");
        persons.add(man1);
        Person woman1 = new Woman();
        woman1.setAction("成功");
        persons.add(woman1);

        Person man2 = new Man();
        man2.setAction("失败");
        persons.add(man2);

        Person woman2 = new Woman();
        woman2.setAction("失败");
        persons.add(woman2);

        Person man3 = new Man();
        man3.setAction("恋爱");
        persons.add(man3);
        Person woman3 = new Woman();
        woman3.setAction("恋爱");
        persons.add(woman3);

        for(Person item : persons) {
            item.getConclusion();
        }

        System.out.println();
        System.out.println("**********************************************");
    }
}

//人抽象类
abstract class Person {
    protected String action;
    public String getAction(){
        return this.action;
    }
    public void setAction(String value){
        this.action = value;
    }
    //得到结论或反应
    public abstract void getConclusion();
}

//男人
class Man extends Person {
    //得到结论或反应
    public void getConclusion() {
        if (action == "成功") {
            System.out.println(this.getClass().getSimpleName()+this.action+"时，背后多半有一个伟大的女人。");
        }
        else if (action == "失败") {
            System.out.println(this.getClass().getSimpleName()+this.action+"时，闷头喝酒，谁也不用劝。");
        }
        else if (action == "恋爱") {
            System.out.println(this.getClass().getSimpleName()+this.action+"时，凡事不懂也要装懂。");
        }
    }
}

//女人
class Woman extends Person {
    //得到结论或反应
    public  void getConclusion() {
        if (action == "成功") {
            System.out.println(this.getClass().getSimpleName()+this.action+"时，背后大多有一个不成功的男人。");
        }
        else if (action == "失败") {
            System.out.println(this.getClass().getSimpleName()+this.action+"时，眼泪汪汪，谁也劝不了。");
        }
        else if (action == "恋爱") {
            System.out.println(this.getClass().getSimpleName()+this.action+"时，遇事懂也装作不懂。");
        }
    }
}