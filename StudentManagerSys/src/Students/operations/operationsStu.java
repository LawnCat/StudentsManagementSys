package Students.operations;

import Main.interface_.StudentsOperations;
import Students.student;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Chen_Cat
 */
public class operationsStu implements StudentsOperations {

    @Override
    public void queryPersonalInformation(student std) {

        System.out.println("-------------------------");
        System.out.println("姓名：" + std.getName());
        System.out.println("学号：" + std.getId());
        System.out.println("性别：" + std.getGender());
        System.out.println("年龄：" + std.getAge());
        System.out.println("手机号：" + std.getPhone());
        System.out.println("专业：" + std.getMajor());
        System.out.println("班级：" + std.getClassNum());
        System.out.println("入学时间： " + std.getEntrance_time());
        System.out.println("-------------------------");
    }

    @Override
    public void queryPersonalGrade(student std) {
        System.out.println("-------------------------");
        System.out.printf("线性代数成绩：" );
        if (std.getMath_score() == -1) {
            System.out.println("未考试");
        } else {
            System.out.println(std.getMath_score());
            System.out.println();
        }

        System.out.printf("英语成绩：");
        if (std.getEnglish_score() == -1) {
            System.out.println("未考试");
        } else {
            System.out.println(std.getEnglish_score());
            System.out.println();
        }
        System.out.printf("JAVA成绩：");
        if (std.getJAVA_score() == -1) {
            System.out.println("未考试");
        } else {
            System.out.println(std.getJAVA_score());
            System.out.println();
        }

        System.out.printf("总成绩：");
        if (std.total() == -3) {
            System.out.println("未考试");
        } else {
            System.out.println(std.total());
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    @Override
    public void changeMajor(HashMap<student,String> messageData, student std) {
        Scanner scanner = new Scanner(System.in);
//        判断一下是否考试
        if(std.total() == -3){
            System.out.println("您还未考试，无法转专业");
            return;
        }
//        先判断是否符合条件转专业
        boolean flag = true;
        if(std.getMath_score() <= 80){
            System.out.println("您的线性代数成绩为：" + std.getMath_score() + "，不符合转专业条件");
            flag = false;
        }
        if (std.getEnglish_score() <= 80) {
            System.out.println("您的英语成绩为：" + std.getEnglish_score() + "，不符合转专业条件");
            flag = false;
        }
        if (std.getJAVA_score() <= 80) {
            System.out.println("您的JAVA成绩为：" + std.getJAVA_score() + "，不符合转专业条件");
            flag = false;
        }
        if (flag) {
            System.out.println("您符合转专业条件，是否转专业？（Y/N）");
            String s = scanner.next();
            if (s.equals("Y") || s.equals("y")) {
                System.out.println("请输入您要转的专业：");
                String major = scanner.next();
                messageData.put(std,major);
                System.out.println("申请成功");
            } else {
                System.out.println("您已取消转专业！");
            }
        }
    }

    @Override
    public void changePassword(student std) {
        System.out.println("请输入您的新密码：");
        Scanner scanner = new Scanner(System.in);
        int password = scanner.nextInt();
        System.out.println("请再次输入您的新密码：");
        int password1 = scanner.nextInt();
        if (password == password1) {
            std.setPassword(password);
            System.out.println("修改成功！");
        } else {
            System.out.println("两次输入的密码不一致！");
        }
    }
}
