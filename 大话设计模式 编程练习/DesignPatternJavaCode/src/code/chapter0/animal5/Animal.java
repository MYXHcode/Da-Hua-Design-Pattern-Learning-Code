package code.chapter0.animal5;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public abstract class Animal {

    protected String name = "";
    public Animal(String name){
        this.name = name;
    }

    public Animal(){
        this.name="无名";
    }

    protected int shoutNum = 3;
    public void setShoutNum(int value){
        this.shoutNum=value;
    }
    public int getShoutNum(){
        return this.shoutNum;
    }

    public String shout(){
        String result="";
        for(int i=0;i<this.shoutNum;i++){
            result+= getShoutSound()+", ";
        }
        return "我的名字叫"+ name + " " + result;
    }

    protected abstract String getShoutSound();

}