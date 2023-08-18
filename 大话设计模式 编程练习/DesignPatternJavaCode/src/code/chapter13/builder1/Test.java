package code.chapter13.builder1;

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

        //瘦小人
        g.drawOval(150, 120, 30, 30);   //头
        g.drawRect(160, 150, 10, 50);   //身体
        g.drawLine(160, 150, 140, 200); //左手
        g.drawLine(170, 150, 190, 200); //右手
        g.drawLine(160, 200, 145, 250); //左脚
        g.drawLine(170, 200, 185, 250); //右脚

        //胖小人
        g.drawOval(250, 120, 30, 30);   //头
        g.drawOval(245, 150, 40, 50);   //身体
        g.drawLine(250, 150, 230, 200); //左手
        g.drawLine(280, 150, 300, 200); //右手
        g.drawLine(260, 200, 245, 250); //左脚

        
        g.drawLine(270, 200, 285, 250); //右脚

    }

    public static void main(String[] args) {
        new Test().setVisible(true);
    }
}