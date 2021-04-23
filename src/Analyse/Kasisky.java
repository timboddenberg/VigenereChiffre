package Analyse;

import Cryption.Decryption;
import Helpers.Alphabet;
import Models.KasiskyTestRun;

import java.util.*;

public class Kasisky
{
    private String message;
    private int possibleKeyLength;

    private Map<String, Integer> occurences = new HashMap<>();
    private Map<Integer, List<String>> sortedOccurences = new HashMap<>();

    private List<Integer> indexes = new ArrayList<>();
    private int[] distances;

    private List<KasiskyTestRun> kasiskyTestRuns = new ArrayList<>();

    public Kasisky(String message)
    {
        this.message = message;
        checkOccurences();
        sortOccurences();
        buildKasiskyTestRuns();
        printResults();
    }

    private void checkOccurences()
    {
        String substring;
        for (int i = 4; i <= 6; i++)
        {
            for (int j = 0; j < ((message.length() - i) +1); j++)
            {
                substring = "";
                for (int l = 0; l < i; l++)
                {
                    substring = substring + message.charAt(j+l);
                }
                if (occurences.containsKey(substring))
                    occurences.put(substring,occurences.get(substring) + 1);
                else
                    occurences.put(substring,1);
            }
        }
    }

    private void sortOccurences()
    {
        for (Map.Entry<String, Integer> entry : occurences.entrySet())
        {
            if (sortedOccurences.containsKey(entry.getValue()))
            {
                List<String> list = sortedOccurences.get(entry.getValue());
                list.add(entry.getKey());
            }
            else
            {
                List<String> newList = new ArrayList<>();
                newList.add(entry.getKey());
                sortedOccurences.put(entry.getValue(), newList);
            }
        }

        if (sortedOccurences.containsKey(1))
        {
            sortedOccurences.remove(1);
            sortedOccurences.remove(2);

            if (sortedOccurences.containsKey(3) && sortedOccurences.get(3).size() > 3 && sortedOccurences.containsKey(4))
                sortedOccurences.remove(3);
        }
    }

    private void buildKasiskyTestRuns()
    {
        Decryption decryption = new Decryption();

        for (Map.Entry<Integer, List<String>> occurence : sortedOccurences.entrySet()) {
            for (String repetition : occurence.getValue())
            {
                KasiskyTestRun testRun = new KasiskyTestRun();
                testRun.setRepetition(repetition);
                testRun.setOccurenceCounter(occurence.getKey());
                testRun.setIndexes(findIndexesOfRepetition(testRun.getRepetition()));
                testRun.setDistances(findDistancesOfOccurences(testRun.getIndexes()));
                testRun.setPossibleKeyLengths(findPossibleKeyLengths(testRun.getIndexes(), testRun.getDistances()));
                possibleKeyLength = findPossibleKeyLengths(testRun.getIndexes(), testRun.getDistances()).get(0);
                testRun.setMessageWithWhiteSpace(this.splitStringByPossibleKeyLength(testRun.getPossibleKeyLength().get(0)));
                testRun.setSplittedFrequences(SplitStringInArray(testRun.getMessageWithWhiteSpace()));
                testRun.setPossibleKey(doStatisticalAnalyseAndReturnKey(testRun.getSplittedFrequences()));

                decryption.setKey(testRun.getPossibleKey());
                decryption.setMessage(message);
                decryption.DecriptMessage(false);

                testRun.setDecryptedMessage(decryption.getDecryptedMessage());

                kasiskyTestRuns.add(testRun);
            }
        }
    }

    public List<Integer> findIndexesOfRepetition(String repetition)
    {
        boolean allFound = false;
        int index = 0;
        List<Integer> indexes = new ArrayList<>();

        while (! allFound)
        {
            int currentIndex;
            currentIndex = message.indexOf(repetition,index);

            if (currentIndex > 0)
            {
                indexes.add(currentIndex);
                index = currentIndex+repetition.length();
            }
            else
                allFound = true;
        }

        return indexes;
    }

    public int[] findDistancesOfOccurences(List<Integer> indexes)
    {
        distances = new int[indexes.size()-1];

        for (int i=0; i<(indexes.size()-1); i++)
        {
            int distance = ((indexes.get(i) - indexes.get(i+1)) * (-1));
            distances[i] = distance;
        }

        return distances;
    }

    private List<Integer> findPossibleKeyLengths(List<Integer> indexes, int[] distances)
    {
        int length = indexes.size();
        int smallestDistance = findSmallestDistance();

        List<Integer> possibleKeyLengths = new ArrayList<>();

        // Fehlerpotential bei komischer Längenauswahl
        if (length > 1)
        {
            for (int i = 0; i < (length-1); i++)
            {
                for (int j = i + 1; j < (length-1); j++)
                {
                    int foundGGT = euklid(distances[i], distances[j]);
                    if (foundGGT <= smallestDistance)
                        if (! possibleKeyLengths.contains(foundGGT))
                            possibleKeyLengths.add(foundGGT);
                }
            }
        }

        return possibleKeyLengths;
    }

    private int findSmallestDistance()
    {
        int smallestInt = distances[0];

        for (int distance : distances) {
            if (distance < smallestInt)
                smallestInt = distance;
        }

        return smallestInt;
    }

    private int euklid (int a, int b)
    {
        if (a == 0)
            return b;
        else
            {
                while (b != 0)
                {
                    if (a > b)
                        a = a-b;
                    else
                        b = b-a;
                }
            }

        return a;
    }

    private String splitStringByPossibleKeyLength(int length)
    {
        int counter = length;

        String tempSubstring;
        String messageWithWhitespace = "";

        while (counter < message.length())
        {
            tempSubstring = message.substring((counter-length) , counter);
            tempSubstring = tempSubstring.concat(" ");
            messageWithWhitespace= messageWithWhitespace + tempSubstring;
            counter += length;
        }

        return messageWithWhitespace;
    }

    private String[] SplitStringInArray(String messageWithWhitespace)
    {
        String[] stringArray = messageWithWhitespace.split("\\s+");

        String[] characterArray = new String[possibleKeyLength];

        for (int j = 0; j < possibleKeyLength; j++)
        {
            for (int i = 0; i < stringArray.length; i++)
            {
                if (characterArray[j] != null)
                    characterArray[j] = characterArray[j] + Character.toString(stringArray[i].charAt(j));
                else
                    characterArray[j] = Character.toString(stringArray[i].charAt(j));
            }
        }

        return characterArray;
    }

    private String doStatisticalAnalyseAndReturnKey(String[] splittedFrequences)
    {
        String key = "";
        int positionE = Alphabet.getLetterPosition("e");

        for (int i=0; i < splittedFrequences.length; i++)
        {
            OccurenceAnalysis analysis = new OccurenceAnalysis(splittedFrequences[i]);
            analysis.analyzeMostUsedLetter(false);

            int currentLetterPosition = Alphabet.getLetterPosition(analysis.getMostUsedLetter().toLowerCase());

            int difference = 0;
            if (currentLetterPosition < positionE)
                difference = currentLetterPosition + (26 - positionE);
            else
                difference = currentLetterPosition - positionE;

            key = key + Alphabet.getLetterById(difference);

            //System.out.println();
        }

        return key;
    }

    public void printResults()
    {
        int counter = 1;
        for (KasiskyTestRun testRun : kasiskyTestRuns)
        {
            System.out.println("<----------------------------------------------------------------->");
            System.out.println(counter + ". Versuch:");
            System.out.println("Versuch mit Teilfrequenz: " + testRun.getRepetition());
            System.out.println("Vorkommen: " + testRun.getOccurenceCounter());
            System.out.println("Wahrscheinliche Schlüssellänge: " + testRun.getPossibleKeyLength());
            System.out.println("Wahrscheinlicher Key: " + testRun.getPossibleKey());
            System.out.println();
            System.out.println("Mögliche Übersetzung:");
            System.out.println(testRun.getDecryptedMessage());
            System.out.println();
            counter++;
        }
    }

    public void setPossibleKeyLength(int keyLength)
    {
        possibleKeyLength = keyLength;
    }


}
