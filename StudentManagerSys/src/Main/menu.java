package Main;

import Teacher.teacher;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Chen_Cat
 */
public class menu {
    static Scanner  scanner = new Scanner(System.in);
//    第一层首页
    public static int menu() {
        System.out.println("------------欢迎使用学生管理系统------------");
        System.out.println("                1、学生端                 ");
        System.out.println("                2、教师端                 ");
        System.out.println("                3、退出系统                ");
        System.out.printf("请选择:");
        int choice = scanner.nextInt();
        return choice;
    }

    public static void menu2(){

    }


}
