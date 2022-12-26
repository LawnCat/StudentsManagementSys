package Main;

import DataBase.student_data;
import DataBase.teacher_data;
import Main.IO.readFile;
import Students.student;
import Teacher.teacher;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author 陈勇
 * @Major 网络工程K2102班
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        创建数据库
        LinkedHashSet<teacher> teacherSet = teacher_data.return_teacherSet();
        LinkedHashSet<student> studentSet = student_data.return_studentSet();
        HashMap<student,String> messageData = DataBase.MessageForChangeMajor.return_messageData();
//        创建admin
        teacher teacher = new teacher(1, "陈勇", 123);
        teacherSet.add(teacher);

//        老师测试案例
//        student student = new student(2101,"陈勇","男",18,"网络工程","网络工程本科21级","18236416916",123,"2021年");
//        student student1 = new student(2102,"王生","男",18,"网络工程","网络工程本科21级","18236416916",123,"2021年");
//        studentSet.add(student);
//        studentSet.add(student1);

//        将数据导入集合中
        readFile.inputStudentFile(studentSet);
      while(true){
          int choice = menu.menu();
          switch (choice){
              case 1:
                  StudentLoginAndIndex.student_login(messageData,studentSet);
                  break;
              case 2:
                  TeacherLoginAndIndex.teacher_login(teacherSet,studentSet);
                  break;
              case 3:
                  break;
          }
      }
    }
}