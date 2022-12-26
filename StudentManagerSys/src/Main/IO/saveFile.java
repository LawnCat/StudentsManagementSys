package Main.IO;

import Students.student;

import java.io.*;
import java.util.LinkedHashSet;

/**
 * @author Chen_Cat
 */
public class saveFile {
    //    保存文件
    public static void saveStudentFile(LinkedHashSet<student> studentSet) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter("D:\\javacode_idea\\StudentManagerSys\\src\\DataBase\\txtData\\StudentsData.txt");
            bufferedWriter = new BufferedWriter(writer);
            for (student student : studentSet) {
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
                System.out.println("----");
            }
            System.out.println("写入成功！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                writer.flush();
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    方法重载 可以接受单个学生信息
    public static void saveStudentFile(student student) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter("D:\\javacode_idea\\StudentManagerSys\\src\\DataBase\\txtData\\StudentsData.txt",true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
            System.out.println("写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                writer.flush();
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
