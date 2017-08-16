package cipher;

import services.EnigmaService;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;



public class NumericCipher implements EnigmaService{

  public static final boolean KEY_REQUIRED = false;

  public String encipher(String text){

    String newString = "";
    HashMap<String, String> keyCipher = DataManager.loadFile("data_manager/numberscipher.txt");

    for (int i = 0; i < text.length(); i ++){
      Character letter = text.charAt(i);

      newString += keyCipher.get(letter.toString());
    }

    return "ciphered: "+newString;
  }

  public String dencipher(String text){
    String deciphredText = "";
    HashMap<String, String> keysCipher = DataManager.loadFile("numberscipher.txt");

    for (int i = 0; i < text.length(); i = i + 2){
      Character number1 = text.charAt(i);
      Character number2 = text.charAt(i+1);
      String hiddenLetter = number1.toString() + number2.toString();

      for (String key: keysCipher.keySet()){
        if (keysCipher.get(key).equals(hiddenLetter)){
          deciphredText += key;
        }
      }
    }
		return "deciphered: "+deciphredText;
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
