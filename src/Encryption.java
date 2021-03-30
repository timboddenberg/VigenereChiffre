public class Encryption extends Cryption
{
    private String cryptedMessage;

    public void EncryptMessage()
    {
        int row;
        int column;
        cryptedMessage = "";

        for (int i = 0; i < message.length(); i++)
        {
            row = table.getLetterPosition(keySplitted[i]);
            column = table.getLetterPosition(messageSplitted[i]);

            if (row >= 0 && column >= 0)
                cryptedMessage = cryptedMessage.concat(chiffreTable[row][column]);
            else
                System.out.println("Es wurde keine Reihe für key " + keySplitted[i] + " und keine Spalte für " + messageSplitted[i] + " gefunden.");
        }
    }

    public String getEncryptedMessage()
    {
        return cryptedMessage;
    }
}
