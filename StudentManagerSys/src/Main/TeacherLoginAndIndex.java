package Main;

import Main.IO.saveFile;
import Students.student;
import Teacher.operations.student_grades;
import Teacher.operations.students_base;
import Teacher.teacher;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Chen_Cat
 */
public class TeacherLoginAndIndex {

    static Scanner scanner = new Scanner(System.in);

    public static void teacher_login(LinkedHashSet<teacher> teacherSet, LinkedHashSet<student> studentSet) throws IOException {
//        用来判断教师是否登录成功;
//        当flag = -1 表示没有该教师
//        当flag = 0 表示有改教师 但是密码输入错误
//        当flag = 1 表示有改教师 并且密码输入正确
        int flag = -1;
        int id = 0;
        int password = 0;
        teacher teacher = null;
        System.out.println("----------教师端登录界面-----------");
        try {
            System.out.printf("请输入职工号：");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("请输入数字，请重新输入");
            teacher_login(teacherSet, studentSet);
        }

        System.out.println();
        try {
            System.out.printf("请输入密码：");
            password = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("请输入数字，请重新输入");
            teacher_login(teacherSet, studentSet);
        }

        for (teacher t : teacherSet) {
            if (t.getId() == id) {
                flag = 0;
                if (t.getPassword() == password) {
                    teacher = t;
                    flag = 1;
                }
            }
        }

        if (flag == -1) {
            System.out.println("未查询到相关用户信息");
            System.out.printf("是否重新输入？（y/n）");
            String s = scanner.next();
            if (s.equals("y")) {
                teacher_login(teacherSet, studentSet);
            } else {
                System.out.println("退出系统");
                System.exit(0);
            }
        } else if (flag == 0) {
            System.out.println("密码输入有误");
            System.out.printf("是否重新输入？（y/n）");
            String s = scanner.next();
            if (s.equals("y")) {
                teacher_login(teacherSet, studentSet);
            } else {
                System.out.println("退出系统");
                System.exit(0);
            }

        } else {
            System.out.println("登录成功");
            System.out.println("欢迎" + teacher.getName() + "老师");
            System.out.println("正在跳转到教师端界面....");
            teacher_index(teacher, studentSet);
        }
    }

    public static void teacher_index(teacher teacher, LinkedHashSet<student> studentSet) throws IOException {
        System.out.println("----------教师端主界面-----------");
        System.out.println("          1、学生基本信息管理         ");
        System.out.println("          2、学生成绩管理         ");
        System.out.println("          3、邮件信息         ");
        System.out.println("          4、退出系统         ");
        int choice = 0;
        try {
            System.out.printf("请输入您的选择：");
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("请输入数字，请重新输入");
            teacher_index(teacher, studentSet);
        }
        switch (choice) {
            case 1:
                System.out.println("正在跳转到学生基本信息管理界面....");
                student_info(teacher, studentSet);
                break;
            case 2:
                System.out.println("正在跳转到学生成绩管理界面....");
                student_grades(teacher, studentSet);
                break;
            case 3:
                System.out.println("正在跳转到邮件信息界面....");
                break;
            case 4:
                saveFile.saveStudentFile(studentSet);
                System.out.println("退出系统");
                System.exit(0);
                break;
            default:
                System.out.println("输入有误，请重新输入");
                teacher_index(teacher, studentSet);
                break;
        }
    }

    public static void student_info(teacher teacher, LinkedHashSet<student> studentSet) throws IOException {
        while (true) {
            System.out.println("--------学生基本信息管理界面--------");
            System.out.println("          1、添加学生信息         ");
            System.out.println("          2、删除学生信息         ");
            System.out.println("          3、修改学生信息         ");
            System.out.println("          4、查询学生信息         ");
            System.out.println("          5、打印所有学生信息         ");
            System.out.println("          6、返回上一级         ");
            System.out.println("          7、退出系统         ");
            int choice = 0;
            try {
                scanner = new Scanner(System.in);
                System.out.printf("请输入您的选择：");
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("请输入数字，请重新输入");
                student_info(teacher, studentSet);
            }
            students_base studentsBase = new students_base();
            switch (choice) {
                case 1:
                    System.out.println("正在跳转到添加学生信息界面....");
                    studentsBase.addStudent(studentSet);
                    break;
                case 2:
                    System.out.println("正在跳转到删除学生信息界面....");
                    studentsBase.deleteStudent(studentSet);
                    break;
                case 3:
                    System.out.println("正在跳转到修改学生信息界面....");
                    studentsBase.updateStudent(studentSet);
                    break;
                case 4:
                    System.out.println("正在跳转到查询学生信息界面....");
                    studentsBase.queryStudent(studentSet);
                    break;
                case 5:
                    System.out.println("正在跳转到打印所有学生信息界面....");
                    studentsBase.printAllStudent(studentSet);
                    break;
                case 6:
                    System.out.println("正在返回上一级....");
                    teacher_index(teacher, studentSet);
                    break;
                case 7:
                    saveFile.saveStudentFile(studentSet);
                    System.out.println("退出系统");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    student_info(teacher, studentSet);
                    break;
            }
        }

    }

    public static void student_grades(teacher teacher, LinkedHashSet<student> studentSet) throws IOException {
        while (true) {
            System.out.println("--------学生成绩管理界面--------");
            System.out.println("         1、添加学生成绩         ");
            System.out.println("         2、修改学生成绩         ");
            System.out.println("         3、查询学生成绩         ");
            System.out.println("         4、打印所有学生成绩         ");
            System.out.println("         5、返回上一级         ");
            System.out.println("         6、退出系统         ");
            int choice = 0;
            try {
                System.out.printf("请输入您的选择：");
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("请输入数字，请重新输入");
                student_grades(teacher, studentSet);
            }
            student_grades studentsGrades = new student_grades();
            switch (choice) {
                case 1:
                    System.out.println("正在跳转到添加学生成绩界面....");
                    studentsGrades.addStudentGrades(studentSet);
                    break;
                case 2:
                    System.out.println("正在跳转到修改学生成绩界面....");
                    studentsGrades.updateStudentGrades(studentSet);
                    break;
                case 3:
                    System.out.println("正在跳转到查询学生成绩界面....");
                    studentsGrades.queryStudentGrades(studentSet);
                    break;
                case 4:
                    System.out.println("正在跳转到打印所有学生成绩界面....");
                    studentsGrades.printAllStudentGrades(studentSet);
                    break;
                case 5:
                    System.out.println("正在返回上一级....");
                    teacher_index(teacher, studentSet);
                    break;
                case 6:
                    saveFile.saveStudentFile(studentSet);
                    System.out.println("退出系统");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    student_grades(teacher, studentSet);
                    break;
            }
        }
    }


}
