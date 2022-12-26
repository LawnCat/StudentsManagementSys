package Teacher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Chen_Cat
 */
public class getIDFromFile {
    public static int getIDFromFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\javacode_idea\\StudentManagerSys\\src\\DataBase\\txtData\\StudentsData.txt"));
        String lastLine = null;
        String currentLine = null;
        if (br.readLine() != null) {
            while((currentLine = br.readLine()) != null) {
                lastLine = currentLine;
            }
            br.close();
            return  Integer.parseInt(lastLine.split(",")[0]) ;
        } else {
            br.close();
            return 2101;
        }
    }
}
