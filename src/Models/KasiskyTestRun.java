package Models;

import java.util.List;

public class KasiskyTestRun
{
    private String Repetition;

    private int occurenceCounter;

    private List<Integer> possibleKeyLength;

    private List<Integer> indexes;

    private int[] distances;

    private String messageWithWhiteSpace;

    private String[] splittedFrequences;

    private String possibleKey;

    private String decryptedMessage;

    public String getRepetition()
    {
        return Repetition;
    }

    public void setRepetition(String repetition)
    {
        Repetition = repetition;
    }

    public List<Integer> getPossibleKeyLength()
    {
        return possibleKeyLength;
    }

    public void setPossibleKeyLengths(List<Integer> possibleKeyLength)
    {
        this.possibleKeyLength = possibleKeyLength;
    }

    public List<Integer> getIndexes()
    {
        return indexes;
    }

    public void setIndexes(List<Integer> indexes)
    {
        this.indexes = indexes;
    }

    public int[] getDistances()
    {
        return distances;
    }

    public void setDistances(int[] distances)
    {
        this.distances = distances;
    }

    public String getMessageWithWhiteSpace()
    {
        return messageWithWhiteSpace;
    }

    public void setMessageWithWhiteSpace(String messageWithWhiteSpace)
    {
        this.messageWithWhiteSpace = messageWithWhiteSpace;
    }

    public String[] getSplittedFrequences()
    {
        return splittedFrequences;
    }

    public void setSplittedFrequences(String[] splittedFrequences)
    {
        this.splittedFrequences = splittedFrequences;
    }

    public String getPossibleKey()
    {
        return possibleKey;
    }

    public void setPossibleKey(String possibleKey)
    {
        this.possibleKey = possibleKey;
    }

    public int getOccurenceCounter()
    {
        return occurenceCounter;
    }

    public void setOccurenceCounter(int occurenceCounter)
    {
        this.occurenceCounter = occurenceCounter;
    }

    public String getDecryptedMessage()
    {
        return decryptedMessage;
    }

    public void setDecryptedMessage(String decryptedMessage)
    {
        this.decryptedMessage = decryptedMessage;
    }
}
