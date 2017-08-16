import java.util.Scanner;
import java.util.ArrayList;

public class MorseCipher {

    public static final boolean KEY_REQUIRED = false;

    public MorseCipher() {}

    public static void main(String[] args){

    }

    public String encipher(String text){
		return "###### ciphered: "+text+" #####";
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
