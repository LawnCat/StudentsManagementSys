package Main.interface_;

import Students.student;

import java.util.HashMap;

/**
 * @author Chen_Cat
 */
public interface StudentsOperations {
//    查看个人信息
    public void queryPersonalInformation(student std);
//    查看个人成绩
    public void queryPersonalGrade(student std);

//    转专业
    public void changeMajor(HashMap<student,String> messageData, student std);
//    更改密码
    public void changePassword(student std);

}
