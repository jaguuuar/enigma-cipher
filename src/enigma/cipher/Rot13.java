package enigma.cipher;
import java.util.Scanner;
import services.EnigmaService;


public class Rot13 implements EnigmaService{

	public static final boolean KEY_REQUIRED = false;

	public Rot13(){}
    public String encipher(String text){
        String rot13 = "";
        int len = text.length();
        for (int i = 0; i < len; i++) {
            char c = (text.charAt(i));



		}
        return "cipher: " + rot13;
}
