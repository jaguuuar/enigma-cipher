public class MirrorCipher{

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
