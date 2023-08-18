package code.chapter0.animal2;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Cattle extends Animal {

    public Cattle (){
        super();
    }
    public Cattle (String name){
        super(name);
    }

    protected String getShoutSound(){
        return "哞";
    }
}