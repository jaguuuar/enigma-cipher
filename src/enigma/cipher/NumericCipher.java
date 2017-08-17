package enigma.cipher;

import services.EnigmaService;
import enigma.cipher.data_manager.DataManager;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class NumericCipher implements EnigmaService{

  public static final boolean KEY_REQUIRED = false;

  public NumericCipher() {
  }

  public String encipher(String text){

    String newString = "";
    HashMap<String, String> keyCipher = DataManager.loadFile("src/enigma/cipher/data_manager/numbersCipher.txt");

    for (String name: keyCipher.keySet()){

            String key = name.toString();
            String value = keyCipher.get(name).toString();

    }

    for (int i = 0; i < text.length(); i ++){
      Character letter = text.charAt(i);

      newString += keyCipher.get(letter.toString());
    }

    return "ciphered: " + newString;
  }

  public String decipher(String text){

    String deciphredText = "";
    HashMap<String, String> keysCipher = DataManager.loadFile("src/enigma/cipher/data_manager/numbersCipher.txt");
    if (text.length() % 2 == 0){
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
    }
    else{
      System.out.println("This text is not combilabe with Numeric Cipher enigma code.");
      System.exit(0);
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
