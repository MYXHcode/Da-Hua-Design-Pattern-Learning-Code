package code.chapter6.decorator2;

/**
 * @author MYXH
 * @date 2023/4/7
 */

public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的"+name);
    }
}