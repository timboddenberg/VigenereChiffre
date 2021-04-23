package Analyse;

import java.util.HashMap;
import java.util.Map;

public class OccurenceAnalysis
{
    private final String message;

    private final Map<String, Integer> occurrences = new HashMap<>();

    private String mostUsedLetter;

    public OccurenceAnalysis(String message)
    {
        fillHashmap();
        this.message = message;
    }

    public void analyzeMostUsedLetter(boolean printResult)
    {
        analyzeOccurences();
        findMostUsedLetter();

        if (printResult)
            printAnalyzedResult();
    }

    public String getMostUsedLetter()
    {
        return mostUsedLetter;
    }

    public Map<String, Integer> getOccurrences()
    {
        return occurrences;
    }

    private void printAnalyzedResult()
    {
        System.out.println("Abbildung von " + mostUsedLetter + " auf e ist sehr wahrscheinlich");
    }

    private void analyzeOccurences()
    {
        String currentLetter = "";
        for (int i=0; i < message.length(); i++)
        {
            currentLetter = Character.toString(message.charAt(i));
            if (occurrences.containsKey(currentLetter))
                occurrences.put(currentLetter, occurrences.get(currentLetter) + 1);
            else
                occurrences.put(currentLetter, 1);
        }
    }

    private void findMostUsedLetter()
    {
        int highestInt = 0;

        for (Map.Entry<String, Integer> letter : occurrences.entrySet())
        {
            if (letter.getValue() > highestInt)
            {
                highestInt = letter.getValue();
                mostUsedLetter = letter.getKey();
            }
        }

        int counter = 0;
        for (Map.Entry<String, Integer> letter : occurrences.entrySet())
        {
            if (letter.getValue() == highestInt)
            {
                counter ++;
            }
        }

        if (counter > 1)
            System.out.println("hier könnten es mind. 2 sein");

    }

    private void fillHashmap()
    {
        occurrences.put("a", 0);
        occurrences.put("b", 0);
        occurrences.put("c", 0);
        occurrences.put("d", 0);
        occurrences.put("e", 0);
        occurrences.put("f", 0);
        occurrences.put("g", 0);
        occurrences.put("h", 0);
        occurrences.put("i", 0);
        occurrences.put("j", 0);
        occurrences.put("k", 0);
        occurrences.put("l", 0);
        occurrences.put("m", 0);
        occurrences.put("n", 0);
        occurrences.put("o", 0);
        occurrences.put("p", 0);
        occurrences.put("q", 0);
        occurrences.put("r", 0);
        occurrences.put("s", 0);
        occurrences.put("t", 0);
        occurrences.put("u", 0);
        occurrences.put("v", 0);
        occurrences.put("w", 0);
        occurrences.put("x", 0);
        occurrences.put("y", 0);
        occurrences.put("z", 0);
    }
}
