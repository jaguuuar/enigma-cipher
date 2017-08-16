import java.util.Scanner;
import java.lang.StringBuffer;

public class MirrorCipher{

		public static final boolean KEY_REQUIRED = false;


		public static void main(String[] args){

			MirrorCipher mirror = new MirrorCipher();
			Scanner input = new Scanner(System.in);
			String text = input.nextLine();
			String enciperText = mirror.encipher(text);
			System.out.println(enciperText);

		}

		public String encipher(String text){
		  String reverse = new StringBuffer(text).reverse().toString();
		  return "###### ciphered: "+reverse+" #####";
		}

		public String decipher(String text){
		  String reverse = new StringBuffer(text).reverse().toString();
		  return "###### deciphered: "+reverse+" #####";
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

