public class ChiffreTable
{
    public ChiffreTable()
    {
        buildUpChiffreTable();
    }

    private final String[][] chiffreTable = new String[26][26];
    private final String[] alphabet = Alphabet.getAlphabet();

    private void buildUpChiffreTable()
    {
        int innerIterator = 0;
        for (int i=0; i< 26; i++)
        {
            innerIterator = 0;
            int j = i;
            while(innerIterator < 26){
                if (j == 26)
                    j = 0;

                chiffreTable[i][innerIterator] = alphabet[j];

                j++;
                innerIterator++;
            }
        }
    }

    public int getLetterPosition(String letter)
    {
        int counter = 0;

        while (counter < 26)
        {
            if (letter.equals(alphabet[counter]))
                return counter;

            counter++;
        }

        return -1;
    }

    public int findLetterPositionInRow(int row, String letter)
    {
        int counter = 0;

        while (counter < 26)
        {
            if (letter.equals(chiffreTable[row][counter]))
                return counter;

            counter++;
        }

        return -1;
    }

    public String[][] getChiffreTable()
    {
        return chiffreTable;
    }
}
