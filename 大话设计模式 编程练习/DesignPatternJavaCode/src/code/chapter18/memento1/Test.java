package code.chapter18.memento1;

/**
 * @author MYXH
 * @date 2023/4/18
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        //大战Boss前
        GameRole role = new GameRole();
        role.getInitState();
        role.displayState();

        //保存进度
        GameRole backup = new GameRole();
        backup.setVitality(role.getVitality());
        backup.setAttack(role.getAttack());
        backup.setDefense(role.getDefense());

        //大战Boss时，损耗严重
        role.fight();
        //显示状态
        role.displayState();

        //游戏进度恢复
        role.setVitality(backup.getVitality());
        role.setAttack(backup.getAttack());
        role.setDefense(backup.getDefense());

        //显示状态
        role.displayState();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//游戏角色类
class GameRole {
    //生命力
    private int vitality;

    public int getVitality() {
        return this.vitality;
    }

    public void setVitality(int value) {
        this.vitality = value;
    }

    //攻击力
    private int attack;

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int value) {
        this.attack = value;
    }

    //防御力
    private int defense;

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int value) {
        this.defense = value;
    }

    //状态显示
    public void displayState() {
        System.out.println("角色当前状态：");
        System.out.println("体力：" + this.vitality);
        System.out.println("攻击力：" + this.attack);
        System.out.println("防御力：" + this.defense);
        System.out.println();
    }

    //获得初始状态(数据通常来自本机磁盘或远程数据接口)
    public void getInitState() {
        this.vitality = 100;
        this.attack = 100;
        this.defense = 100;
    }

    //战斗(在与Boss大战后游戏数据损耗为0)
    public void fight() {
        this.vitality = 0;
        this.attack = 0;
        this.defense = 0;
    }

}