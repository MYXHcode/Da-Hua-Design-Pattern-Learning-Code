package code.chapter0.animal5;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class MachineCat extends Cat implements IChange {

    public MachineCat (){
        super();
    }
    public MachineCat (String name){
        super(name);
    }

    public String changeThing(String thing){
        return super.shout()+ " 我有万能的口袋，我可变出" + thing;
    }
}