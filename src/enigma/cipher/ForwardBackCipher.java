package enigma.cipher;

import services.EnigmaService;

public class ForwardBackCipher implements EnigmaService {

	public static final boolean KEY_REQUIRED = false;

	public ForwardBackCipher(){
	}

	public String encipher(String text)
    {
        char[] alphabet = makeAlphabetTable();
        String encipherText = "";

        for (int i = 0; i < text.length(); i++)
        {
            char textCharacter = text.charAt(i);

            if (!Character.isLetter(textCharacter))
                encipherText += textCharacter;

            else
            {
                for (int j = 1; j < 53; j++)
                {
                    char alphabetLetter = alphabet[j];
                    if(textCharacter == alphabetLetter )
                    {
                        encipherText += alphabet[j + 1];
                        encipherText += alphabet[j - 1];
                    }
                }
            }
        }
		return encipherText;
	}

	public String decipher(String text)
    {
        char[] alphabet = makeAlphabetTable();
        String decipherText = "";

        for (int i = 0; i < text.length(); i++)
        {
            char textCharacter = text.charAt(i);

            if (!Character.isLetter(textCharacter))
                decipherText += textCharacter;

            else
            {
                for (int j = 1; j < 53; j++)
                {
                    char alphabetLetter = alphabet[j];
                    if(textCharacter == alphabetLetter )
                    {
                        decipherText += alphabet[j - 1];
                        i++;
                    }
                }
            }
        }
		return decipherText;
	}

	public String getName(){
		return "ForwardBackCipher";
	}

	public boolean isKeyRequired(){
		return KEY_REQUIRED;
	}

	public void setKey(String key) {}

    public static char[] makeAlphabetTable()
    {
		char[] alpha = new char[54];
        alpha[0] = 'z'; alpha[53] = 'A';
        int k = 0;
        for(int i = 1; i < 27; i++)
        {
            alpha[i] = (char)(65 + (k++));
        }

        k = 0;
        for(int i = 27; i < 53; i++)
        {
            alpha[i] = (char)(97 + (k++));
        }

        return alpha;
    }

}
