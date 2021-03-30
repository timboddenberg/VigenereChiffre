public class Alphabet
{
    private static final String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static String[] getAlphabet()
    {
        return alphabet;
    }

    public static int getLetterPosition(String letter)
    {
        for (int i=0; i < alphabet.length; i++)
        {
            if (alphabet[i].equals(letter))
                return i;
        }

        return 0;
    }

    public static String getLetterById(int id)
    {
        return alphabet[id];
    }
}
