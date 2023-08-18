package code.chapter0.animal4;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Monkey extends Animal {

    public Monkey (){
        super();
    }
    public Monkey (String name){
        super(name);
    }

    protected String getShoutSound(){
        return "吱";
    }
}