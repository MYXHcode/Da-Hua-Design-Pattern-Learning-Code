package code.chapter0.animal3;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class AnimalFactory {

    public static Animal createAnimal(String animalCategory, String animalName,int shoutNumber)
    {
        Animal result=null;
        switch (animalCategory)
        {
            case "猫":
                result = new Cat(animalName);
                break;
            case "狗":
                result = new Dog(animalName);
                break;
            case "羊":
                result = new Sheep(animalName);
                break;
        }
        result.setShoutNum(shoutNumber);

        return result;
    }
}