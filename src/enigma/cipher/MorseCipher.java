package cipher;

import services.EnigmaService;
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

          newString += keyCipher.get(letter.toString());
        }

        return "######## ciphered: " + encipheredText + " #########";
	}

    public String decipher(String text){
		return "###### deciphered: "+text+" #####";
	}

    public String getName(){
		return "FakeEnigma";
	}

    public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

    public void setKey(String key){}

}
