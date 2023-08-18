package code.chapter18.memento2;

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
        RoleStateCaretaker stateAdmin = new RoleStateCaretaker();
        stateAdmin.setRoleStateMemento(role.saveState());

        //大战Boss时，损耗严重
        role.fight();
        //显示状态
        role.displayState();

        //游戏进度恢复
        role.recoveryState(stateAdmin.getRoleStateMemento());

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

    //保存角色状态
    public RoleStateMemento saveState() {
        return new RoleStateMemento(this.vitality, this.attack, this.defense);
    }

    //恢复角色状态
    public void recoveryState(RoleStateMemento memento) {
        this.setVitality(memento.getVitality());
        this.setAttack(memento.getAttack());
        this.setDefense(memento.getDefense());
    }
}

//角色状态存储箱
class RoleStateMemento {
    private int vitality;
    private int attack;
    private int defense;

    //将生命力、攻击力、防御力存入状态存储箱对象中
    public RoleStateMemento(int vitality, int attack, int defense) {
        this.vitality = vitality;
        this.attack = attack;
        this.defense = defense;
    }

    //生命力
    public int getVitality() {
        return this.vitality;
    }

    public void setVitality(int value) {
        this.vitality = value;
    }

    //攻击力
    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int value) {
        this.attack = value;
    }

    //防御力
    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int value) {
        this.defense = value;
    }
}

//角色状态管理者
class RoleStateCaretaker {

    private RoleStateMemento memento;

    public RoleStateMemento getRoleStateMemento() {
        return this.memento;
    }

    public void setRoleStateMemento(RoleStateMemento value) {
        this.memento = value;
    }
}