import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class OccurenceAnalysis
{
    public OccurenceAnalysis()
    {
        fillHashmap();
    }

    private String message;

    private Map<String, Integer> occurences = new HashMap<>();

    private String mostUsedLetter;

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void printAnalyzedResult()
    {
        System.out.println("Abbildung von " + mostUsedLetter + " auf e ist sehr wahrscheinlich");
    }

    public void analyzeOccurences()
    {
        String currentLetter = "";
        for (int i=0; i < message.length(); i++)
        {
            currentLetter = Character.toString(message.charAt(i));
            occurences.put(currentLetter, occurences.get(currentLetter) + 1);
        }
    }

    public void sortLettersByOccurence()
    {
        int highestInt = 0;

        for (Map.Entry<String, Integer> letter : occurences.entrySet())
        {
            if (letter.getValue() > highestInt)
            {
                highestInt = letter.getValue();
                mostUsedLetter = letter.getKey();
            }
        }

    }

    private void fillHashmap()
    {
        occurences.put("a", 0);
        occurences.put("b", 0);
        occurences.put("c", 0);
        occurences.put("d", 0);
        occurences.put("e", 0);
        occurences.put("f", 0);
        occurences.put("g", 0);
        occurences.put("h", 0);
        occurences.put("i", 0);
        occurences.put("j", 0);
        occurences.put("k", 0);
        occurences.put("l", 0);
        occurences.put("m", 0);
        occurences.put("n", 0);
        occurences.put("o", 0);
        occurences.put("p", 0);
        occurences.put("q", 0);
        occurences.put("r", 0);
        occurences.put("s", 0);
        occurences.put("t", 0);
        occurences.put("u", 0);
        occurences.put("v", 0);
        occurences.put("w", 0);
        occurences.put("x", 0);
        occurences.put("y", 0);
        occurences.put("z", 0);
    }
}
