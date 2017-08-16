public class ForwardBackCipher
{
    public static void main(String[] args)
    {
        String ciphered = encipherForwardBack("DUPA");
        System.out.println(ciphered);

        String ciphered2 = decipherForwardBack("ecvtqobz");
        System.out.println(ciphered2);
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
            for (int j = 1; j < 27; j++)
            {
                char textLetter = Character.toLowerCase(text.charAt(i));
                char alphabetLetter = alphabet[j];
                if(textLetter == alphabetLetter )
                {
                    encipherText = encipherText + alphabet[j + 1];
                    encipherText = encipherText + alphabet[j - 1];
                }
            }

        }
        return encipherText;
    }


    public static String decipherForwardBack(String text)
    {
        char[] alphabet = makeAlphabetTable();
        String decipherText = "";

        for (int i = 0; i < text.length(); i = i + 2)
        {
            for (int j = 1; j < 27; j++)
            {
                char textLetter = Character.toLowerCase(text.charAt(i));
                char alphabetLetter = alphabet[j];
                if(textLetter == alphabetLetter )
                {
                    decipherText = decipherText + alphabet[j - 1];
                }
            }

        }
        return decipherText;
    }

}
