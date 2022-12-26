package Students;

import java.util.Objects;

/**
 * @author Chen_Cat
 */
//学生类，定义学生的属性
public class student {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String major;
    private String classNum;
    private String phone;
    private int password;
    private double math_score = -1;
    private double english_score = -1;
    private double JAVA_score = -1;
    private String entrance_time;

    //    此构造器用于添加学生基本信息
    public student(int id, String name, String gender, int age, String major, String classNum, String phone, int password, String entrance_time) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.major = major;
        this.classNum = classNum;
        this.phone = phone;
        this.password = password;
        this.entrance_time = entrance_time;
    }

    //    此构造器用于添加学生成绩
    public student(double math_score, double english_score, double JAVA_score) {
        this.math_score = math_score;
        this.english_score = english_score;
        this.JAVA_score = JAVA_score;
    }


//    重写equals方法和hashCode，用于判断学生是否存在，学生不得在同一专业同一班级中重名
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return Objects.equals(name, student.name) && Objects.equals(major, student.major) && Objects.equals(classNum, student.classNum);
    }

    public student() {
    }

    @Override
    public String toString() {
        return  id+","+name+","+gender+","+age+","+major+","+classNum+","+phone+","+password+","+math_score+","+english_score+","+JAVA_score+","+entrance_time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, major, classNum);
    }

    public double total() {
        return  (math_score + english_score + JAVA_score);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public double getMath_score() {
        return math_score;
    }

    public void setMath_score(double math_score) {
        this.math_score = math_score;
    }

    public double getEnglish_score() {
        return english_score;
    }

    public void setEnglish_score(double english_score) {
        this.english_score = english_score;
    }

    public double getJAVA_score() {
        return JAVA_score;
    }

    public void setJAVA_score(double JAVA_score) {
        this.JAVA_score = JAVA_score;
    }

    public String getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(String entrance_time) {
        this.entrance_time = entrance_time;
    }
}
