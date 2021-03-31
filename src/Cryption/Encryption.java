package Cryption;

public class Encryption extends Cryption
{
    private String encryptedMessage;

    public void EncryptMessage(boolean printResult)
    {
        AdjustKeyToMessageLength();

        int row;
        int column;
        encryptedMessage = "";

        for (int i = 0; i < message.length(); i++)
        {
            row = table.getLetterPosition(keySplitted[i]);
            column = table.getLetterPosition(messageSplitted[i]);

            if (row >= 0 && column >= 0)
                encryptedMessage = encryptedMessage.concat(chiffreTable[row][column]);
            else
                System.out.println("Es wurde keine Reihe für key " + keySplitted[i] + " und keine Spalte für " + messageSplitted[i] + " gefunden.");
        }

        if (printResult)
        {
            System.out.println("Verschlüsselte Nachricht: ");
            System.out.println(encryptedMessage);
        }
    }

    public String getEncryptedMessage()
    {
        return encryptedMessage;
    }
}
