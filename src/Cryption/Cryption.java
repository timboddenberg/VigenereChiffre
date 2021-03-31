package Cryption;

import Helpers.ChiffreTable;

public class Cryption
{
    protected String message;
    protected String[] messageSplitted;

    protected String key;
    protected String[] keySplitted;

    protected ChiffreTable table = new ChiffreTable();
    protected String[][] chiffreTable = table.getChiffreTable();

    public void setMessage(String message)
    {
        this.message = message.replaceAll("\\s+","");
        this.message = this.message.toLowerCase();
        messageSplitted = splitString(this.message);
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return key;
    }

    protected void AdjustKeyToMessageLength()
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
