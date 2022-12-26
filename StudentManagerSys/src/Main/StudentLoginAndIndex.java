package Main;

import Main.IO.saveFile;
import Students.operations.operationsStu;
import Students.student;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Chen_Cat
 * @Time 2022/12/8 16:00
 */
@SuppressWarnings("all")
public class StudentLoginAndIndex {
    static Scanner scanner = new Scanner(System.in);
    public static void student_login(HashMap<student,String> messageData, LinkedHashSet<student> studentSet) {
        int id = 0;
        System.out.println("----------学生端登录界面-----------");
        try {
            scanner = new Scanner(System.in);
            System.out.printf("请输入学号：");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入有误，请重新输入");
            student_login(messageData,studentSet);
        }
//        判断学生是否存在
        boolean flag = false;
        for (student s : studentSet) {
            if (s.getId() == id) {
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("未查询到相关用户信息");
            System.out.printf("是否重新输入？（y/n）");
            String s = scanner.next();
            if (s.equals("y")) {
                student_login(messageData,studentSet);
            } else {
                System.out.println("退出系统");
                System.exit(0);
            }
        }
        int password = 0;
        try {
            scanner = new Scanner(System.in);
            System.out.println();
            System.out.printf("请输入密码：");
            password = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入有误，请重新输入");
            student_login(messageData,studentSet);
        }


//        判断密码是否正确
        for (student s : studentSet) {
            if (s.getId() == id) {
                if (s.getPassword() == password) {
                    System.out.println("登录成功");
                    student_index(messageData,s);
                } else {
                    System.out.println("密码输入有误");
                    System.out.printf("是否重新输入？（y/n）");
                    String s1 = scanner.next();
                    if (s1.equals("y")) {
                        student_login(messageData,studentSet);
                    } else {
                        System.out.println("退出系统");
                        System.exit(0);
                    }
                }
            }
        }

    }
   public static void student_index(HashMap<student,String> messageData,student student){
       operationsStu operationStu = new operationsStu();
       while(true){
            System.out.println("----------学生端主界面-----------");
            System.out.println("1、查看个人信息");
            System.out.println("2、查看个人成绩");
            System.out.println("3、申请转专业");
            System.out.println("4、更改密码");
            System.out.println("5、退出系统");
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    operationStu.queryPersonalInformation(student);
                    break;
                case 2:
                    operationStu.queryPersonalGrade(student);
                    break;
                case 3:
                    operationStu.changeMajor(messageData,student);
                    break;
                case 4:
                    operationStu.changePassword(student);
                    break;
                case 5:
                    saveFile.saveStudentFile(student);
                    System.out.println("退出系统");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }

        }
   }


}
