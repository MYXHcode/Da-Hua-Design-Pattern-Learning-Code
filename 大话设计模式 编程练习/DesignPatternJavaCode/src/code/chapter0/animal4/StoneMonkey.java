package code.chapter0.animal4;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class StoneMonkey extends Monkey implements IChange {

    public StoneMonkey (){
        super();
    }
    public StoneMonkey (String name){
        super(name);
    }

    protected String getShoutSound(){
        return "俺老孙来也";
    }

    public String changeThing(String thing){
        return super.shout()+ " 我会七十二变，可变出" + thing;
    }
}