package Main.interface_;

import Students.student;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author Chen_Cat
 */
public interface operations_students_base {
    //增加学生信息
    public  void addStudent(LinkedHashSet<student> studentSet) throws IOException;
    //删除学生信息
    public void deleteStudent(LinkedHashSet<student> studentSet);
    //修改学生信息
    public void updateStudent(LinkedHashSet<student> studentSet);
    //查询学生信息
    public void queryStudent(LinkedHashSet<student> studentSet);
    //打印所有学生信息
    public void printAllStudent(LinkedHashSet<student> studentSet);
//    邮件
    public  void meail(HashMap<student,String> messageData );

}
