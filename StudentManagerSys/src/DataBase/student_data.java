package DataBase;

import Students.student;

import java.util.LinkedHashSet;

/**
 * @author Chen_Cat
 */
//该数据库类用于存储学生信息
public class student_data {
    public static LinkedHashSet<student> return_studentSet(){
        LinkedHashSet<student>  studentSet = new LinkedHashSet();
        return studentSet;
    }
}
