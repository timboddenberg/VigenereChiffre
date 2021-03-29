public class Decryption
{
    public Decryption()
    {
        //fillHashmap();
    }

    private String message;
    private String[] messageSplitted;

    private String key;
    private String[] keySplitted;

    private String decryptedMessage;

    private ChiffreTable table = new ChiffreTable();
    private String[][] chiffreTable = table.getChiffreTable();

    public void setMessage(String message)
    {
        this.message = message.replaceAll("\\s+","");
        this.message = this.message.toLowerCase();
        messageSplitted = splitString(message);
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void AdjustKeyToMessageLength()
    {
        int messageLength = message.length();

        while (key.length() < messageLength)
        {
            key = key.concat(key);
        }

        if (key.length() > messageLength)
        {
            int difference = key.length() - messageLength;

            key = key.substring(0, key.length() - difference);
        }

        keySplitted = splitString(key);
    }

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

    private String[] splitString(String string)
    {
        String[] splittedString = new String[string.length()];
        for (int i=0; i< string.length(); i++)
        {
            splittedString[i] = Character.toString(string.charAt(i));
        }
        return splittedString;
    }

}
