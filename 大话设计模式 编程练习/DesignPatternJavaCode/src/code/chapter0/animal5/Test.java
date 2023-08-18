package code.chapter0.animal5;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Test {

    public static void main(String[] args){

        ArrayList<Animal> arrayAnimal=new ArrayList<Animal>();
        arrayAnimal.add(AnimalFactory.createAnimal("猫","小花",1));
        arrayAnimal.add(AnimalFactory.createAnimal("狗","阿毛",2));
        arrayAnimal.add(AnimalFactory.createAnimal("狗","小黑",3));
        arrayAnimal.add(AnimalFactory.createAnimal("猫","娇娇",4));
        arrayAnimal.add(AnimalFactory.createAnimal("猫","咪咪",5));
        for(Animal item : arrayAnimal){
            System.out.println(item.shout());
        }
        System.out.println("动物个数："+arrayAnimal.size());

        arrayAnimal.add(AnimalFactory.createAnimal("羊","喜羊羊",1));

        System.out.println(arrayAnimal.get(5).shout());

        System.out.println("动物个数："+arrayAnimal.size());

        arrayAnimal.remove(1);

        arrayAnimal.remove(1);

        for(Animal item : arrayAnimal){
            System.out.println(item.shout());
        }
    }
}