package code.chapter13.builder3;

import javax.swing.*;
import java.awt.*;

/**
 * @author MYXH
 * @date 2023/4/13
 */

class Test extends JFrame {

    public Test() {
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {

        PersonBuilder gThin = new PersonThinBuilder(g);
        PersonDirector pdThin = new PersonDirector(gThin);
        pdThin.CreatePerson();

        PersonBuilder gFat = new PersonFatBuilder(g);
        PersonDirector pdFat = new PersonDirector(gFat);
        pdFat.CreatePerson();

    }

    public static void main(String[] args) {
        new Test().setVisible(true);
    }
}

//抽象的建造者类
abstract class PersonBuilder {
    protected Graphics g;

    public PersonBuilder(Graphics g) {
        this.g = g;
    }

    public abstract void buildHead();       //头

    public abstract void buildBody();       //身体

    public abstract void buildArmLeft();    //左手

    public abstract void buildArmRight();   //右手

    public abstract void buildLegLeft();    //左脚

    public abstract void buildLegRight();   //右脚
}

//瘦小人建造者
class PersonThinBuilder extends PersonBuilder {

    public PersonThinBuilder(Graphics g) {
        super(g);
    }

    public void buildHead() {
        g.drawOval(150, 120, 30, 30);   //头
    }

    public void buildBody() {
        g.drawRect(160, 150, 10, 50);   //身体
    }

    public void buildArmLeft() {
        g.drawLine(160, 150, 140, 200); //左手
    }

    public void buildArmRight() {
        g.drawLine(170, 150, 190, 200); //右手
    }

    public void buildLegLeft() {
        g.drawLine(160, 200, 145, 250); //左脚
    }

    public void buildLegRight() {
        g.drawLine(170, 200, 185, 250); //右脚 
    }
}

//胖小人建造者
class PersonFatBuilder extends PersonBuilder {
    public PersonFatBuilder(Graphics g) {
        super(g);
    }

    public void buildHead() {
        g.drawOval(250, 120, 30, 30);   //头
    }

    public void buildBody() {
        g.drawOval(245, 150, 40, 50);   //身体
    }

    public void buildArmLeft() {
        g.drawLine(250, 150, 230, 200); //左手
    }

    public void buildArmRight() {
        g.drawLine(280, 150, 300, 200); //右手
    }

    public void buildLegLeft() {
        g.drawLine(260, 200, 245, 250); //左脚
    }

    public void buildLegRight() {
        g.drawLine(270, 200, 285, 250); //右脚
    }
}

//指挥者
class PersonDirector {

    private PersonBuilder pb;

    //初始化时指定需要建造什么样的小人
    public PersonDirector(PersonBuilder pb) {
        this.pb = pb;
    }

    //根据用户的需要建造小人
    public void CreatePerson() {
        pb.buildHead();     //头
        pb.buildBody();     //身体
        pb.buildArmLeft();  //左手
        pb.buildArmRight(); //右手
        pb.buildLegLeft();  //左脚
        pb.buildLegRight(); //右脚
    }
}