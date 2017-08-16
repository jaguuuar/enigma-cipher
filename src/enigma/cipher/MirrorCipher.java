public class MirrorCipher{
	
		public static final boolean KEY_REQUIRED = false;


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
