package DataBase;

import Students.student;

import java.util.HashMap;

/**
 * @author Chen_Cat
 * 此数据库用于存放学生转专业的信息，
 */

public class MessageForChangeMajor {
    public static HashMap<student,String > return_messageData(){
        HashMap<student,String> messageData = new HashMap<>();
        return messageData;
    }
}
