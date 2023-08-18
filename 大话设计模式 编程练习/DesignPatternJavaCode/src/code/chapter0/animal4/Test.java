package code.chapter0.animal4;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Test {
    public static void main(String[] args){
        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();
        // Animal[] arrayAnimal=new Animal[10];
        // int index=0;
        // arrayAnimal[0] = AnimalFactory.createAnimal("猫","小花",1);
        // arrayAnimal[1] = AnimalFactory.createAnimal("狗","阿毛",2);
        // arrayAnimal[2] = AnimalFactory.createAnimal("狗","小黑",3);
        // arrayAnimal[3] = AnimalFactory.createAnimal("猫","娇娇",4);
        // arrayAnimal[4] = AnimalFactory.createAnimal("猫","咪咪",5);
        // for(int i=0;i<5;i++){
        // System.out.println(arrayAnimal[i].shout());
        // }

        MachineCat mcat = new MachineCat("叮噹");
        StoneMonkey wukong = new StoneMonkey("孙悟空");
        IChange[] array = new IChange[2];
        array[0] = mcat;
        array[1] = wukong;
        System.out.println(array[0].changeThing("各种各样的东西！"));
        System.out.println();
        System.out.println(array[1].changeThing("各种各样的东西！"));

        System.out.println();
        System.out.println("**********************************************");
    }
}