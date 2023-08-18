package code.chapter0.animal4;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Cat extends Animal {


    public Cat (){
        super();
    }
    public Cat (String name){
        super(name);
    }

    protected String getShoutSound(){
        return "喵";
    }
}
