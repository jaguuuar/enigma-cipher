package enigma.cipher;

import services.EnigmaService;
import enigma.cipher.data_manager.DataManager;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class MorseCipher {

    public static final boolean KEY_REQUIRED = false;

    public MorseCipher() {}

    public String encipher(String text) {

        String encipheredText = "";
        HashMap<String, String> morseCode = DataManager.loadFile("data_manager/morse_code.txt");

        for (int i = 0; i < text.length(); i ++){
          Character letter = text.charAt(i);

          if (!letter.toString().equals("~")) {
            encipheredText += morseCode.get(letter.toString()) + "#";
            }
        }

        return "######## ciphered: " + encipheredText + " #########";
	}

    public String decipher(String text){

        String deciphredText = "";
        HashMap<String, String> morseCode = DataManager.loadFile("numberscipher.txt");

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
		return "MorseCipher";
	}

    public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

    public void setKey(String key){}

}
