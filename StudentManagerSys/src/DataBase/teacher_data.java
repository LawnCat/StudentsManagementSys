package DataBase;

import Teacher.teacher;

import java.util.LinkedHashSet;

/**
 * @author Chen_Cat
 */
//该数据库类用于存储教师信息
public class teacher_data {

    static public LinkedHashSet<teacher> return_teacherSet() {
        LinkedHashSet<teacher> teacherSet = new LinkedHashSet();
        return teacherSet;
    }
}
