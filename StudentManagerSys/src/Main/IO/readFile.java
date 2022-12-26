package Main.IO;

import Students.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

/**
 * @author Chen_Cat
 */
public class readFile {
    //    将数据读入集合中
    public static void inputStudentFile(LinkedHashSet<student> studentSet) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\javacode_idea\\StudentManagerSys\\src\\DataBase\\txtData\\StudentsData.txt"));
        String line =null;
        while((line = br.readLine())!=null ){
//            将读取到的字符串用split进行分割，得到一个字符串数组
            String[] split = line.split(",");
//            将字符串数组中的数据分别赋值给student对象的属性
            student s = new student();
            s.setId(Integer.parseInt(split[0]));
            s.setName(split[1]);
            s.setGender(split[2]);
            s.setAge(Integer.parseInt(split[3]));
            s.setMajor(split[4]);
            s.setClassNum(split[5]);
            s.setPhone(split[6]);
            s.setPassword(Integer.parseInt(split[7]));
            s.setMath_score(Double.parseDouble(split[8]));
            s.setEnglish_score(Double.parseDouble(split[9]));
            s.setJAVA_score(Double.parseDouble(split[10]));
            s.setEntrance_time(split[11]);
            studentSet.add(s);
        }
        br.close();
    }
}
