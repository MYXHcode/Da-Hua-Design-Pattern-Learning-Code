package code.chapter0.animal2;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Test {

    public static void main(String[] args){


        Animal[] arrayAnimal=new Animal[5];
        arrayAnimal[0] = new Cat("小花");
        arrayAnimal[0].setShoutNum(10);
        arrayAnimal[1] = new Dog("阿毛");
        arrayAnimal[2] = new Dog("小黑");
        arrayAnimal[3] = new Cat("娇娇");
        arrayAnimal[4] = new Cat("咪咪");

        for(int i=0;i<5;i++){
            System.out.println(arrayAnimal[i].shout());
        }
    }
}