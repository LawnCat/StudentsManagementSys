package Teacher.operations;

import Students.student;
import Main.interface_.operations_students_base;
import Teacher.getIDFromFile;
import Teacher.setID;
import Teacher.teacher;

import java.io.*;
import java.util.*;

/**
 * @author Chen_Cat
 */
@SuppressWarnings("all")
public class students_base implements operations_students_base {
    Scanner scanner = new Scanner(System.in);
    private static int id;
    //    count作用就是当添加学生信息的时候判断是否为进入系统以来第一次添加
    static int count = 0;
    @Override
    public void addStudent(LinkedHashSet<student> studentSet) throws IOException {
//        如果当count等于0的时候就代表第一次添加数据此时应获取文件中最后一行数据的id
        if (count == 0) {
            id = setID.setID();
//            当搞完之后就给count赋一个值，如果再添加信息的话就不会再从文件中获取而直接从当前的
//            id中获取
            count = 1;
            System.out.println("第一次添加");
        } else {
            System.out.println("第二次添加-----");
        }
        System.out.println("当前ID为" + id);
        String name = null;
        String gender = null;
        int age = 0;
        String major = null;
        String classNum = null;
        String phone = null;
        String entrance_time = null;
        int password = 0;
        boolean flag = true;
        while (flag) {
            try {
                scanner = new Scanner(System.in);
                System.out.println("请输入学生的姓名：");
                name = scanner.next();
                System.out.println("请输入学生性别：");
                gender = scanner.next();
                System.out.println("请输入学生年龄：");
                age = scanner.nextInt();
                System.out.println("请输入学生专业：");
                major = scanner.next();
                System.out.println("请输入学生班级：");
                classNum = scanner.next();
                System.out.println("请输入学生电话：");
                phone = scanner.next();
                System.out.println("请输入学生入学时间：");
                entrance_time = scanner.next();
                System.out.println("请为学生设置密码：");
                password = scanner.nextInt();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("输入有误，请重新输入");
            }
        }
        student student = new student(id++, name, gender, age, major, classNum, phone, password, entrance_time);
        if (studentSet.add(student)) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败，学生已存在");
        }
    }

    @Override
    public void deleteStudent(LinkedHashSet<student> studentSet) {
        String name = null;
        String major = null;
        String classNum = null;

        System.out.printf("请输入学生的姓名：");
        name = scanner.next();
        System.out.printf("请输入学生专业");
        major = scanner.next();
        System.out.printf("请输入学生班级");
        classNum = scanner.next();


        student student = new student(0, name, null, 0, major, classNum, null, 0, null);
        if (studentSet.remove(student)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败，学生不存在");
        }
    }

    //    选择修改学生的个别信息
    @Override
    public void updateStudent(LinkedHashSet<student> studentSet) {
        System.out.printf("请输入要修改的学生的姓名：");
        String name = scanner.next();
//该内部类是为了方便在以下for循环遍历的时候，可以直接使用student对象修改相关信息.起到了封装的作用
        boolean flag = false;
        for (student student : studentSet) {
            if (student.getName().equals(name)) {
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("该学生不存在");
            return;
        }
        class unity_student {
            //            修改学生的性别
            public void updateGender() {
                System.out.printf("请修改学生的性别");
                String gender = scanner.next();
                for (student student : studentSet) {
                    if (student.getName().equals(name)) {
                        student.setGender(gender);
                    }
                }
                System.out.println("修改成功");
            }

            //            修改学生年龄
            public void updateAge() {
                System.out.printf("请修改学生的年龄");
                int age = scanner.nextInt();
                for (student student : studentSet) {
                    if (student.getName().equals(name)) {
                        student.setAge(age);
                    }
                }
                System.out.println("修改成功");
            }

            //            修改学生电话
            public void updatePhone() {
                System.out.printf("请修改学生的电话");
                String phone = scanner.next();
                for (student student : studentSet) {
                    if (student.getName().equals(name)) {
                        student.setPhone(phone);
                    }
                }
                System.out.println("修改成功");
            }

            //修改学生班级
            public void updateClassNum() {
                System.out.printf("请修改学生的班级");
                String classNum = scanner.next();
                for (student student : studentSet) {
                    if (student.getName().equals(name)) {
                        student.setClassNum(classNum);
                    }
                }
                System.out.println("修改成功");
            }
        }
        unity_student unityStudent = new unity_student();
        System.out.printf("请输入需要修改的信息：1.性别 2.年龄 3.电话 4.班级 \n每个数字之间用空格隔开,不需要修改的信息输入0\n请输入：");
        int[] choice = new int[4];
        for (int i = 0; i < 4; i++) {
            choice[i] = scanner.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            if (choice[i] != 0) {
                switch (choice[i]) {
                    case 1:
                        unityStudent.updateGender();
                        break;
                    case 2:
                        unityStudent.updateAge();
                        break;
                    case 3:
                        unityStudent.updatePhone();
                        break;
                    case 4:
                        unityStudent.updateClassNum();
                        break;
                    default:
                        System.out.println("输入错误");
                        break;
                }
            }
        }
    }

    @Override
    public void queryStudent(LinkedHashSet<student> studentSet) {
        System.out.printf("请输入学生的姓名:");
        String name = scanner.next();
        boolean flag = false;
//        查找学生信息
        for (student student : studentSet) {
            if (student.getName().equals(name)) {
                System.out.println("学号: " + student.getId());
                System.out.println("姓名: " + student.getName());
                System.out.println("性别: " + student.getGender());
                System.out.println("年龄: " + student.getAge());
                System.out.println("专业: " + student.getMajor());
                System.out.println("班级: " + student.getClassNum());
                System.out.println("电话: " + student.getPhone());
                System.out.println("入学时间: " + student.getEntrance_time());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("查无此人");
        }
    }

    @Override
    public void printAllStudent(LinkedHashSet<student> studentSet) {
        System.out.println("学号" + "\t\t" + "姓名" + "\t\t" + "性别" + "\t\t" + "年龄" + "\t\t" + "手机号" + "\t\t\t" + "专业" + "\t\t\t" + "班级" + "\t\t\t\t\t\t" + "入学时间");
        for (student student : studentSet) {
            System.out.println(student.getId() + "\t" + student.getName() + "\t\t" + student.getGender() + "\t\t" + student.getAge() + "\t\t" + student.getPhone() + "\t\t" + student.getMajor() + "\t\t" + student.getClassNum() + "\t\t\t" + student.getEntrance_time());
        }
        System.out.println("共有" + studentSet.size() + "个学生");
    }

    public void meail(HashMap<student, String> messageData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("正在连接数据库....");
        System.out.println("---------共有" + messageData.size() + "封邮件---------");
        for (Map.Entry<student, String> entry : messageData.entrySet()) {
            System.out.println("发件人：" + entry.getKey().getName() + "\t" + "转专业->" + entry.getValue());
            System.out.println("是否批准？(y/n)）");
            String choice = scanner.next();
            if (choice.equals("y") || choice.equals("Y")) {
                System.out.println("正在批准....");
                System.out.println("批准成功");
                messageData.remove(entry.getKey());
            } else if (choice.equals("n") || choice.equals("N")) {
                System.out.println("正在拒绝....");
                System.out.println("拒绝成功");
                messageData.remove(entry.getKey());
            } else {
                System.out.println("输入有误，请重新输入");
                meail(messageData);
            }
        }
    }
}
