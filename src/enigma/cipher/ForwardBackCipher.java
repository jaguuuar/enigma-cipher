public class ForwardBackCipher
{
    public static void main(String[] args)
    {
        String ciphered = encipherForwardBack("123swinia arka 123");
        System.out.println(ciphered);

        String ciphered2 = decipherForwardBack("123trxvjhomjhbz bzsqljbz 123");
        System.out.println(ciphered2);

        char test = 'g';
        System.out.println(Character.isLetter(test));


    }

    public static char[] makeAlphabetTable()
    {
        char[] alpha = new char[28];
        alpha[0] = 'z'; alpha[27] = 'a';
        int k = 0;
        for(int i = 1; i < 27; i++)
        {
            alpha[i] = (char)(97 + (k++));
        }
        return alpha;
    }

    public static String encipherForwardBack(String text)
    {
        char[] alphabet = makeAlphabetTable();
        String encipherText = "";

        for (int i = 0; i < text.length(); i++)
        {
            char textCharacter = Character.toLowerCase(text.charAt(i));

            if (!Character.isLetter(textCharacter))
                encipherText += textCharacter;

            else
            {
                for (int j = 1; j < 27; j++)
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


    public static String decipherForwardBack(String text)
    {
        char[] alphabet = makeAlphabetTable();
        String decipherText = "";

        for (int i = 0; i < text.length(); i++)
        {
            char textCharacter = Character.toLowerCase(text.charAt(i));

            if (!Character.isLetter(textCharacter))
                decipherText += textCharacter;

            else
            {
                for (int j = 1; j < 27; j++)
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

}
