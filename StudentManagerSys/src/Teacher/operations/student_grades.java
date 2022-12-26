package Teacher.operations;

import Students.student;
import Main.interface_.operations_students_grades;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Chen_Cat
 */
@SuppressWarnings("all")
public class student_grades implements operations_students_grades {
    Scanner input = new Scanner(System.in);

    @Override
    public void addStudentGrades(LinkedHashSet<student> studentSet) {
        System.out.printf("请输入学生的姓名：");
        String name = input.next();
        boolean flag = false;
//        判断学生是否存在
        for (student student : studentSet){
            if(student.getName().equals(name)){
                flag = true;
            }
        }
        if (!flag){
            System.out.println("学生不存在");
            return;
        }
//        添加学生成绩
        double linear_algebra = 0;
        double english = 0;
        double java = 0;
//        判断输入的成绩是否合法
        boolean flag1 = true;
        while (flag1) {
            try {
                System.out.printf("请输入学生的线性代数成绩");
                linear_algebra = input.nextDouble();
                System.out.printf("请输入英语成绩");
                english = input.nextDouble();
                System.out.printf("请输入JAVA成绩");
                java = input.nextDouble();
                flag1 = false;
            } catch (Exception e) {
                System.out.println("请输入数字");
            }
        }
        for(student student : studentSet){
            if(student.getName().equals(name)){
                student.setMath_score(linear_algebra);
                student.setEnglish_score(english);
                student.setJAVA_score(java);
            }
        }
        System.out.println("添加成功");
    }


    @Override
    public void updateStudentGrades(LinkedHashSet<student> studentSet) {
        System.out.printf("请输入学生的姓名：");
        String name = input.next();
        boolean flag = false;
//        判断学生是否存在
        for (student student : studentSet){
            if(student.getName().equals(name)){
                flag = true;
            }
        }
        if (!flag){
            System.out.println("学生不存在");
            return;
        }
//        修改学生成绩
        System.out.printf("请输入学生的线性代数成绩: ");
        double linear_algebra = input.nextDouble();
        System.out.printf("请输入英语成绩: ");
        double english = input.nextDouble();
        System.out.printf("请输入JAVA成绩: ");
        double java = input.nextDouble();
        for(student student : studentSet){
            if(student.getName().equals(name)){
                student.setMath_score(linear_algebra);
                student.setEnglish_score(english);
                student.setJAVA_score(java);
            }
        }
        System.out.println("修改成功");
    }

    @Override
    public void queryStudentGrades(LinkedHashSet<student> studentSet) {
        System.out.printf("请输入学生的姓名：");
        String name = input.next();
        boolean flag = false;
//        判断学生是否存在
        for (student student : studentSet){
            if(student.getName().equals(name)){
                flag = true;
            }
        }
        if (!flag){
            System.out.println("学生不存在");
            return;
        }
//        查询学生成绩
        for(student student : studentSet){
            if(student.getName().equals(name)){
                System.out.println("学生姓名："+student.getName());
                System.out.println("学生学号："+student.getId());
                System.out.println("学生性别："+student.getGender());
                System.out.println("学生年龄："+student.getAge());
                System.out.println("学生线性代数成绩："+student.getMath_score());
                System.out.println("学生英语成绩："+student.getEnglish_score());
                System.out.println("学生JAVA成绩："+student.getJAVA_score());
            }
        }

    }

    @Override
    public void printAllStudentGrades(LinkedHashSet<student> studentSet) {
        System.out.println("姓名    学号    性别    年龄    线性代数成绩    英语成绩    JAVA成绩");
        for(student student : studentSet){
            System.out.println(student.getName()+"    "+student.getId()+"    "+student.getGender()+"     "+student.getAge()+"      "+student.getMath_score()+"         "+student.getEnglish_score()+"      "+student.getJAVA_score());


        }
    }
}

