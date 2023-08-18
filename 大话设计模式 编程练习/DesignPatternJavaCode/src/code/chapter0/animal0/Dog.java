package code.chapter0.animal0;

/**
 * @author MYXH
 * @date 2023/4/1
 */

public class Dog {

    private String name = "";
    public Dog(String name){
        this.name = name;
    }

    public Dog(){
        this.name="无名";
    }

    private int shoutNum = 3;
    public void setShoutNum(int value){
        this.shoutNum=value;
    }
    public int getShoutNum(){
        return this.shoutNum;
    }

    public String shout(){
        String result="";
        for(int i=0;i<this.shoutNum;i++){
            result+= "汪 ";
        }
        return " 我的名字叫"+ name + " " + result;
    }
}