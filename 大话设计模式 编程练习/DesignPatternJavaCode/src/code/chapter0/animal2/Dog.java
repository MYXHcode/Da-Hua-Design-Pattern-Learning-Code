package code.chapter0.animal2;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Dog extends Animal {

    public Dog (){
        super();
    }
    public Dog (String name){
        super(name);
    }

    protected String getShoutSound(){
        return "汪";
    }
}