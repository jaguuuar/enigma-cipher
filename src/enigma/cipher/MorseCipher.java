public class MorseCipher {

    public static final boolean KEY_REQUIRED = false;
    
    public MorseCipher() {}

    public String encipher(String text){
		return "###### ciphered: "+text+" #####";
	}

    public String decipher(String text){
		return "###### deciphered: "+text+" #####";
	}

    public String getName(){
		return "FakeEnigma";
	}

}
