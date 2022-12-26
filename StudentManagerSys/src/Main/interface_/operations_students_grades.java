package Main.interface_;

import Students.student;

import java.util.LinkedHashSet;

/**
 * @author Chen_Cat
 */
public interface operations_students_grades {
    //增加学生成绩
    public void addStudentGrades(LinkedHashSet<student> studentSet);
    //删除学生成绩
    //修改学生成绩
    public void updateStudentGrades(LinkedHashSet<student> studentSet);
    //查询学生成绩
    public void queryStudentGrades(LinkedHashSet<student> studentSet);
    //打印所有学生成绩
    public void printAllStudentGrades(LinkedHashSet<student> studentSet);
}
