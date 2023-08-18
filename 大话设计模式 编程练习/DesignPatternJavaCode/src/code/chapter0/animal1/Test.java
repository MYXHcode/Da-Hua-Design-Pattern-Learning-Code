package code.chapter0.animal1;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Test {

    public static void main(String[] args){

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Animal[] arrayAnimal=new Animal[5];
        arrayAnimal[0] = new Cat("小花");
        arrayAnimal[1] = new Dog("阿毛");
        arrayAnimal[2] = new Dog("小黑");
        arrayAnimal[3] = new Cat("娇娇");
        arrayAnimal[4] = new Cat("咪咪");

        for(int i=0;i<5;i++){
            System.out.println(arrayAnimal[i].shout());
        }

        System.out.println();

        System.out.println("**********************************************");
    }
}