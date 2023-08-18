package code.chapter0.animal3;

/**
 * @author MYXH
 * @date 2023/4/1
 */
public class Test {

    public static void main(String[] args){

        Animal[] arrayAnimal=new Animal[10];
        int index=0;
        arrayAnimal[0] = AnimalFactory.createAnimal("猫","小花",1);
        arrayAnimal[1] = AnimalFactory.createAnimal("狗","阿毛",2);
        arrayAnimal[2] = AnimalFactory.createAnimal("狗","小黑",3);
        arrayAnimal[3] = AnimalFactory.createAnimal("猫","娇娇",4);
        arrayAnimal[4] = AnimalFactory.createAnimal("猫","咪咪",5);
        for(int i=0;i<5;i++){
            System.out.println(arrayAnimal[i].shout());
        }
    }
}