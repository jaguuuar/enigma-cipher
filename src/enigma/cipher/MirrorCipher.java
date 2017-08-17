package enigma.cipher;

import services.EnigmaService;
import java.util.Scanner;
import java.lang.StringBuffer;

public class MirrorCipher implements EnigmaService{

		public static final boolean KEY_REQUIRED = false;


		public String encipher(String text){
		  String reverse = new StringBuffer(text).reverse().toString();
		  return reverse;
		}

		public String decipher(String text){
		  String reverse = new StringBuffer(text).reverse().toString();
		  return reverse;
		}

		public String getName(){
		  return "MirrorCipher";
		}

		public boolean isKeyRequired(){
		  return KEY_REQUIRED;
		}

		public void setKey(String key) {

		}
}
