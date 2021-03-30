public class Decryption extends Cryption
{
    private String decryptedMessage;

    public void DecriptMessage()
    {
        int row;
        int column;
        decryptedMessage = "";

        for (int i = 0; i < message.length(); i++)
        {
            row = table.getLetterPosition(keySplitted[i]);
            column = table.findLetterPositionInRow(row, messageSplitted[i]);

            if (row >= 0 && column >= 0)
                decryptedMessage = decryptedMessage.concat(chiffreTable[0][column]);
            else
                System.out.println("Es wurde keine Reihe für key " + keySplitted[i] + " und keine Spalte für " + messageSplitted[i] + " gefunden.");
        }
    }

    public String getDecryptedMessage()
    {
        return decryptedMessage;
    }

}
