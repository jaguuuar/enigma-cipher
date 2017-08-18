package enigma.cipher;

import services.EnigmaService;
import enigma.cipher.data_manager.DataManager;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class MorseCipher implements EnigmaService {

    HashMap<String, String> morseCode = DataManager.loadFile("src/enigma/cipher/data_manager/morse_code.txt");
    public static final boolean KEY_REQUIRED = false;

    public MorseCipher() {}

    /**
    * Encipher text from user input.
    * Change letters, numbers or some special chars to special morse code.
    *
    * @param text text from user input to encrypt
    * @return     String, encrypted text
    */
    public String encipher(String text) {

        String encipheredText = "";

        for (int i = 0; i < text.length(); i ++){
            Character letter = text.charAt(i);

            if (!letter.toString().equals(" ") && morseCode.get(letter.toString()) != null) {
                encipheredText += morseCode.get(letter.toString()) + "#";
            }
            else if (letter.toString().equals(" ")) {
                encipheredText += " ";
            }
            else {
                encipheredText += letter.toString();
            }
        }
        return encipheredText;
	}

    /**
    * Decipher text from user input.
    * Change special morse code to letters, numbers or special characters.
    *
    * @param text text from user input to decrypt
    * @return     String, decrypted text
    */
    public String decipher(String text) {

        String deciphredText = "";
        ArrayList<String[]> splittedWords = splitEncryptedText(text);

        for (String[] array : splittedWords) {
            for (String letter : array) {
                for (String key: morseCode.keySet()){
                    if (morseCode.get(key).equals(letter)){
                        deciphredText += key;
                    }
                }
            }
            deciphredText += " ";
        }

        return deciphredText.trim();
    }

    /**
    * Spit encrypted text by whitespaces (to get words) and '#' to get letters.
    *
    * @param text text from user input to encrypt
    * @return     ArrayList<String[]>, ArrayList of Arrays with morse code
    */
    public ArrayList<String[]> splitEncryptedText(String text) {

        String[] unsplittedWords = text.split("\\s");
        ArrayList<String[]> splittedWords = new ArrayList<String[]>();

        for (String word : unsplittedWords) {
            String[] letters = word.split("#");
            splittedWords.add(letters);
        }

        return splittedWords;
    }

    public String getName(){
		return "MorseCipher";
	}

    public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

    public void setKey(String key){}

}
