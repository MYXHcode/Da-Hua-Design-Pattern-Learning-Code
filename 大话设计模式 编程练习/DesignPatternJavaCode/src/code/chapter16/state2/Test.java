package code.chapter16.state2;

/**
 * @author MYXH
 * @date 2023/4/16
 */

public class Test {

    public static void main(String[] args) {

        System.out.println("**********************************************");
        System.out.println("《大话设计模式》代码样例");
        System.out.println();


        //紧急项目
        Work emergencyProjects = new Work();
        emergencyProjects.setHour(9);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(10);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(12);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(13);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(14);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(17);

        emergencyProjects.setWorkFinished(false);
        //emergencyProjects.setWorkFinished(true);

        emergencyProjects.writeProgram();
        emergencyProjects.setHour(19);
        emergencyProjects.writeProgram();
        emergencyProjects.setHour(22);
        emergencyProjects.writeProgram();


        System.out.println();
        System.out.println("**********************************************");

    }


}

//工作类
class Work {
    //时间钟点
    private int hour;

    public int getHour() {
        return this.hour;
    }

    public void setHour(int value) {
        this.hour = value;
    }

    //是否完成工作任务
    private boolean workFinished = false;

    public boolean getWorkFinished() {
        return this.workFinished;
    }

    public void setWorkFinished(boolean value) {
        this.workFinished = value;
    }

    public void writeProgram() {
        if (hour < 12)
            System.out.println("当前时间：" + hour + "点 上午工作，精神百倍");
        else if (hour < 13)
            System.out.println("当前时间：" + hour + "点 饿了，午饭；犯困，午休。");
        else if (hour < 17)
            System.out.println("当前时间：" + hour + "点 下午状态还不错，继续努力");
        else {
            if (workFinished)
                System.out.println("当前时间：" + hour + "点 下班回家了");
            else {
                if (hour < 21)
                    System.out.println("当前时间：" + hour + "点 加班哦，疲累之极");
                else
                    System.out.println("当前时间：" + hour + "点 不行了，睡着了。");
            }
        }
    }
}