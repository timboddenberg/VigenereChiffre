public class Encryption
{
    public Encryption()
    {
        ChiffreTable chiffreTable = new ChiffreTable();
    }

    private String key;
    private String[] keySplitted;

    private String message;
    private String[] messageSplitted;

    private String cryptedMessage;

    private ChiffreTable table = new ChiffreTable();
    private String [][] chiffreTable = table.getChiffreTable();

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setMessage(String message)
    {
        this.message = message.replaceAll("\\s+","");
        this.message = this.message.toLowerCase();
        messageSplitted = splitString(this.message);
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
