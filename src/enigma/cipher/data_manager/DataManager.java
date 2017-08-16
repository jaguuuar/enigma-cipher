import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;

public class DataManager {

    public static HashMap<String, String> loadFile(String fileName){

        HashMap<String, String> codeMap = new HashMap<String, String>();
        File file = new File(fileName);

        try {

            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] splittedCode = line.split("\\s\\|\\s");
                codeMap.put(splittedCode[0], splittedCode[1]);
            }
            read.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    return codeMap;
    }
}
