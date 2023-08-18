package code.chapter0.animal2;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Sheep extends Animal {

    public Sheep (){
        super();
    }
    public Sheep (String name){
        super(name);
    }

    protected String getShoutSound(){
        return "咩";
    }
}