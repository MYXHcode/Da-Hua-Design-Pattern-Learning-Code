package code.chapter12.facade0;

/**
 * @author MYXH
 * @date 2023/4/12
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Facade facade = new Facade();

        facade.methodA();
        facade.methodB();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//外观类
//它需要了解所有的子系统的方法或属性，进行组合，以备外界调用
class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }

    public void methodA() {
        one.methodOne();
        two.methodTwo();
        three.methodThree();
        four.methodFour();
    }

    public void methodB() {
        two.methodTwo();
        three.methodThree();
    }

}

//子系统1
class SubSystemOne {
    public void methodOne() {
        System.out.println("子系统方法一");
    }
}

//子系统2
class SubSystemTwo {
    public void methodTwo() {
        System.out.println("子系统方法二");
    }
}

//子系统3
class SubSystemThree {
    public void methodThree() {
        System.out.println("子系统方法三");
    }
}

//子系统4
class SubSystemFour {
    public void methodFour() {
        System.out.println("子系统方法四");
    }
}