package code.chapter9.prototype3;

/**
 * @author MYXH
 * @date 2023/4/9
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();

        Resume resume1 = new Resume("大鸟");
        resume1.setPersonalInfo("男", "29");
        resume1.setWorkExperience("1998-2000", "XX公司");

        Resume resume2 = resume1.clone();
        resume2.setWorkExperience("2000-2003", "YY集团");

        Resume resume3 = resume1.clone();
        resume3.setPersonalInfo("男", "24");

        resume1.display();
        resume2.display();
        resume3.display();


        System.out.println();
        System.out.println("**********************************************");

    }
}

//简历类
class Resume implements Cloneable {
    private String name;
    private String sex;
    private String age;
    private String timeArea;
    private String company;

    public Resume(String name) {
        this.name = name;
    }

    //设置个人信息
    public void setPersonalInfo(String sex, String age) {
        this.sex = sex;
        this.age = age;
    }

    //设置工作经历
    public void setWorkExperience(String timeArea, String company) {
        this.timeArea = timeArea;
        this.company = company;
    }

    //展示简历
    public void display() {
        System.out.println(this.name + " " + this.sex + " " + this.age);
        System.out.println("工作经历 " + this.timeArea + " " + this.company);
    }

    //实现了clone接口方法
    public Resume clone() {
        Resume object = null;
        try {
            object = (Resume) super.clone();
        } catch (CloneNotSupportedException exception) {
            System.err.println("Clone异常。");
        }
        return object;
    }
}