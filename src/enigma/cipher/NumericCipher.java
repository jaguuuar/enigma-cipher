import java.util.Scanner;
import java.io.File;
import java.util.HashMap;


public class NumericCipher{

  public static final boolean KEY_REQUIRED = false;


  public static void main(String[] args){

    NumericCipher numbCipher = new NumericCipher();
    Scanner input = new Scanner(System.in);
    String text = input.nextLine();
    String enciperText = numbCipher.encipher(text);
    System.out.println(enciperText);
  }

  public String encipher(String text){
    String newString = "";
    HashMap<String, String> keyCipher = DataManager.loadFile("numberscipher.txt");

    for (int i = 0; i < text.length(); i ++){
      Character letter = text.charAt(i);

      newString += keyCipher.get(letter.toString());

    }
    return "ciphered: "+newString+" #####";
  }


  public String getName(){
    return "NumericCipher";
  }

  public void setKey(String key) {

  }

  public boolean isKeyRequired(){
    return KEY_REQUIRED;
  }


}
