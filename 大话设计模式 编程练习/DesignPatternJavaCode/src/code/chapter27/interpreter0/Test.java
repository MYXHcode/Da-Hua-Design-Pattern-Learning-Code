package code.chapter27.interpreter0;

import java.util.ArrayList;

/**
 * @author MYXH
 * @date 2023/4/27
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");       
        System.out.println("《大话设计模式》代码样例");
        System.out.println(); 

        Context context = new Context();
        ArrayList<AbstractExpression> list = new ArrayList<AbstractExpression>();
        list.add(new TerminalExpression());
        list.add(new NonterminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        for (AbstractExpression exp : list) {
            exp.interpret(context);
        }

        System.out.println();
        System.out.println("**********************************************");
    }
}

//抽象表达式类
abstract class AbstractExpression {
    //解释操作
    public abstract void interpret(Context context);
}

//终结符表达式
class TerminalExpression extends AbstractExpression {
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }
}

//非终结符表达式
class NonterminalExpression extends AbstractExpression {
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}

class Context {
    private String input;
    public String getInput(){
        return this.input;
    }
    public void setInput(String value){
        this.input = value;
    }
    
    private String output;
    public String getOutput(){
        return this.output;
    }
    public void setOutput(String value){
        this.output = value;
    }
}