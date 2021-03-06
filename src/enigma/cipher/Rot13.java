package enigma.cipher;
import java.util.Scanner;
import services.EnigmaService;


public class Rot13 implements EnigmaService{

	public static final boolean KEY_REQUIRED = false;

	public Rot13(){}

    public String encipher(String text){

        text = ciphering(text);
        return text;
    }

    public String decipher(String text){

        text = ciphering(text);
        return text;
    }
    
    /**
    * Method to encrypt text
    *
    *@param text String text from user input
    *@return     Encrypted text
    */
    public String ciphering(String text){

        String rot13 = "";
        int len = text.length();

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'm'){
                rot13 += (char) (text.charAt(i) + 13);
            }

            else if (c >= 'A' && c <= 'M'){
                rot13 += (char) (text.charAt(i) + 13);
            }

            else if (c >= 'n' && c <= 'z'){
                rot13 += (char) (text.charAt(i) - 13);
            }

            else if (c >= 'N' && c <= 'Z'){
                rot13 += (char) (text.charAt(i) - 13);
            }
            else if (c == (' ')){
                rot13 += (char) (text.charAt(i));
            }
            else {
                rot13 += (char) (text.charAt(i));
            }
        }
        return rot13;
    }

    public String getName(){
		return "Rot13";
    }

    public boolean isKeyRequired(){
        return KEY_REQUIRED;
    }

    public void setKey(String key){}
}
