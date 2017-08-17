package enigma.cipher;

import services.EnigmaService;
import enigma.cipher.data_manager.DataManager;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class MorseCipher implements EnigmaService {

    public static final boolean KEY_REQUIRED = false;

    public MorseCipher() {}

    public String encipher(String text) {

        String encipheredText = "";
        HashMap<String, String> morseCode = DataManager.loadFile("src/enigma/cipher/data_manager/morse_code.txt");

        for (int i = 0; i < text.length(); i ++){
          Character letter = text.charAt(i);

          if (!letter.toString().equals(" ")) {
            encipheredText += morseCode.get(letter.toString()) + "#";
            }
        }

        return encipheredText;
	}

    public String decipher(String text){

        String deciphredText = "";
        HashMap<String, String> keysCipher = DataManager.loadFile("src/enigma/cipher/data_manager/morse_code.txt");
        return deciphredText;
    }

    public String getName(){
		return "MorseCipher";
	}

    public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

    public void setKey(String key){}

}
