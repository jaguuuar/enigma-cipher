package enigma.cipher;

import services.EnigmaService;
import enigma.cipher.data_manager.DataManager;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class NumericCipher implements EnigmaService{

  public static final boolean KEY_REQUIRED = false;
  HashMap<String, String> keyCipher = DataManager.loadFile("src/enigma/cipher/data_manager/numbersCipher.txt");

  public NumericCipher() {
  }

  /**
  * Encipher text from user input.
  * Change letters to numbers.
  *
  * @param text text from user input to encrypt
  * @return     String, encrypted text
  */
  public String encipher(String text){

    String newString = "";

    for (String name: keyCipher.keySet()){

            String key = name.toString();
            String value = keyCipher.get(name).toString();

    }

    for (int i = 0; i < text.length(); i ++){
      Character letter = text.charAt(i);

      newString += keyCipher.get(letter.toString());
    }

    return newString;
  }

  /**
  * Decipher text from user input.
  * Change numbers to letters.
  *
  * @param text text from user input to decrypt
  * @return     String, decrypted text
  */
  public String decipher(String text){

    String deciphredText = "";

    if (text.length() % 2 == 0){

      for (int i = 0; i < text.length(); i = i + 2){

        Character number1 = text.charAt(i);
        Character number2 = text.charAt(i+1);
        String hiddenLetter = number1.toString() + number2.toString();

        for (String key: keyCipher.keySet()){
          if (keyCipher.get(key).equals(hiddenLetter)){
            deciphredText += key;
          }
        }
      }
    }

    else {

      System.out.println("This text is not combilabe with Numeric Cipher enigma code.");
      System.exit(0);
    }
		return deciphredText;
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
