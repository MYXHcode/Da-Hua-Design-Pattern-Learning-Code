package code.chapter10.templatemethod1;

/**
 * @author MYXH
 * @date 2023/4/10
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        System.out.println("学生甲抄的试卷：");
        TestPaperA studentA = new TestPaperA();
        studentA.testQuestion1();
        studentA.testQuestion2();
        studentA.testQuestion3();

        System.out.println("学生乙抄的试卷：");
        TestPaperB studentB = new TestPaperB();
        studentB.testQuestion1();
        studentB.testQuestion2();
        studentB.testQuestion3();

        System.out.println();
        System.out.println("**********************************************");

    }
}

//学生甲抄的试卷
class TestPaperA {
    //试题1
    public void testQuestion1() {
        System.out.println(" 杨过得到，后来给了郭靖，炼成倚天剑、屠龙刀的玄铁可能是[ ] " +
                " a.球磨铸铁 b.马口铁 c.高速合金钢 d.碳素纤维 ");
        System.out.println("答案：b");
    }

    //试题2
    public void testQuestion2() {
        System.out.println(" 杨过、程英、陆无双铲除了情花，造成[ ] " +
                "a.使这种植物不再害人 b.使一种珍稀物种灭绝 c.破坏了那个生物圈的生态平衡 d.造成该地区沙漠化  ");
        System.out.println("答案：a");
    }

    //试题3
    public void testQuestion3() {
        System.out.println(" 蓝凤凰致使华山师徒、桃谷六仙呕吐不止,如果你是大夫,会给他们开什么药[ ] " +
                "a.阿司匹林 b.牛黄解毒片 c.氟哌酸 d.让他们喝大量的生牛奶 e.以上全不对   ");
        System.out.println("答案：c");
    }
}

//学生乙抄的试卷
class TestPaperB {
    //试题1
    public void testQuestion1() {
        System.out.println(" 杨过得到，后来给了郭靖，炼成倚天剑、屠龙刀的玄铁可能是[ ] " +
                " a.球磨铸铁 b.马口铁 c.高速合金钢 d.碳素纤维 ");
        System.out.println("答案：d");
    }

    //试题2
    public void testQuestion2() {
        System.out.println(" 杨过、程英、陆无双铲除了情花，造成[ ] " +
                "a.使这种植物不再害人 b.使一种珍稀物种灭绝 c.破坏了那个生物圈的生态平衡 d.造成该地区沙漠化  ");
        System.out.println("答案：b");
    }

    //试题3
    public void testQuestion3() {
        System.out.println(" 蓝凤凰致使华山师徒、桃谷六仙呕吐不止,如果你是大夫,会给他们开什么药[ ] " +
                "a.阿司匹林 b.牛黄解毒片 c.氟哌酸 d.让他们喝大量的生牛奶 e.以上全不对   ");
        System.out.println("答案：a");
    }
}