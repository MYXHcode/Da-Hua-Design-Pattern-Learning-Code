package code.chapter25.mediator1;

/**
 * @author MYXH
 * @date 2023/4/25
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        UnitedNationsSecurityCouncil UNSC = new UnitedNationsSecurityCouncil();

        USA c1 = new USA(UNSC);
        Iraq c2 = new Iraq(UNSC);

        UNSC.setUSA(c1);
        UNSC.setIraq(c2);

        c1.declare("不准研制核武器，否则要发动战争！");
        c2.declare("我们没有核武器，也不怕侵略。");


 
        System.out.println();
        System.out.println("**********************************************");
    }
}



abstract class Country {
    protected UnitedNations unitedNations;
    public Country(UnitedNations unitedNations){
        this.unitedNations = unitedNations;
    }
}

class USA extends Country {
    public USA(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void declare(String message) {
        this.unitedNations.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("美国获得对方信息:" + message);
    }
}

class Iraq extends Country {
    public Iraq(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void declare(String message) {
        this.unitedNations.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("伊拉克获得对方信息:" + message);
    }
}

//中介者类
abstract class UnitedNations{
    //声明
    public abstract void declare(String message,Country country);
}

//联合国安理会
class UnitedNationsSecurityCouncil extends UnitedNations{
    private USA countryUSA;
    private Iraq countryIraq;

    public void setUSA(USA value) {
        this.countryUSA = value; 
    }

    public void setIraq(Iraq value) {
        this.countryIraq = value; 
    }

    public void declare(String message, Country country)
    {
        if (country == this.countryUSA) {
            this.countryIraq.getMessage(message);
        }
        else if (country == this.countryIraq) {
            this.countryUSA.getMessage(message);
        }
    }
}