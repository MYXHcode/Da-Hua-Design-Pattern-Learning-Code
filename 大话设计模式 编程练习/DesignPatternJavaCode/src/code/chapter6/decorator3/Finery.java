package code.chapter6.decorator3;

/**
 * @author MYXH
 * @date 2023/4/7
 */

//服饰类
public class Finery implements ICharacter {

    protected ICharacter component;

    public void decorate(ICharacter component) {
        this.component=component;
    }

    public void show() {
        if (this.component != null){
            this.component.show();
        }
    }
}