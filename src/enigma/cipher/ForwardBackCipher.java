public class ForwardBackCipher
{
    public static void main(String[] args)
    {

        char[] alphabet = makeAlphabetTable();
        System.out.println(alphabet);
        // encipherForwardBack("DUPA");

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

    // public static String encipherForwardBack(String text)
    // {
    //     char[] alphabet = makeAlphabetTable();
    //     String encipherText = "";
    //
    //     for (int i = 0; i < text.length(); i++)
    //     {
    //         System.out.println(Character.toLowerCase(text.charAt(i)));
    //         for (int j = 1; j < 27; j++)
    //         {
    //             char textLetter = Character.toLowerCase(text.charAt(i));
    //             char alphabetLetter = alphabet[j];
    //             if(textLetter == alphabetLetter )
    //             {
    //                 encipherText = encipherText + alphabet[i + 1];
    //                 encipherText = encipherText + alphabet[i - 1];
    //             }
    //         }
    //
    //     }
    //
    //     return encipherText;
    //
    //
    //
    // }

}
