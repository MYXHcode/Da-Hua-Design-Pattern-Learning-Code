package code.chapter20.iterator2;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/20
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        ArrayList<String> bus = new ArrayList<String>();
        bus.add("大鸟");
        bus.add("小菜");
        bus.add("行李");
        bus.add("老外");
        bus.add("公交内部员工");
        bus.add("小偷");

        System.out.println("foreach遍历:");
        for (String item : bus) {

            System.out.println(item + "，请买车票!");

        }

        System.out.println();

        System.out.println("Iterator遍历:");
        java.util.Iterator<String> conductor = bus.iterator();
        while (conductor.hasNext()) {
            System.out.println(conductor.next() + "，请买车票!");
        }

        System.out.println();

        System.out.println("ListIterator逆向遍历:");
        java.util.ListIterator<String> conductorDesc = bus.listIterator(bus.size());

        while (conductorDesc.hasPrevious()) {

            System.out.println(conductorDesc.previous() + "，请买车票!");

        }

        System.out.println();
        System.out.println("**********************************************");

    }
}

interface Iterator {

    public boolean hasNext();       //如果迭代具有更多元素，则返回true 

    public Object next();           //返回迭代中的下一个元素

}

interface ListIterator {

    public boolean hasNext();       //如果此列表迭代器在向前遍历列表时具有更多元素，则返回true 

    public Object next();           //返回列表中的下一个元素并前进光标位置

    public boolean hasPrevious();   //如果此列表迭代器在反向遍历列表时具有更多元素，则返回true

    public Object previous();       //返回列表中的上一个元素并向后移动光标位置

}