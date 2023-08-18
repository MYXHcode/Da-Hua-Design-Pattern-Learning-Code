package code.chapter15.abstractfactory5;

/**
 * @author MYXH
 * @date 2023/4/15
 */

//部门类接口
public interface IDepartment {

    public void insert(Department department);

    public Department getDepartment(int id);
}