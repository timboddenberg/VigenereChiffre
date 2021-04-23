package Analyse;

import Helpers.Alphabet;

import javax.sound.midi.SysexMessage;
import java.util.HashMap;
import java.util.Map;

public class Friedmann
{
    private final String message;

    private double friedmannIndex;

    private double possibleKeyLength;

    private final double IZufall = 0.0385;

    private final double Ideutsch = 0.0762;

    private Map<String, Integer> occurrences;

    public Friedmann(String message)
    {
        this.message = message;

        OccurenceAnalysis analysis = new OccurenceAnalysis(message);
        analysis.analyzeMostUsedLetter(false);
        occurrences = analysis.getOccurrences();

        calculateFriedmannIndex();
        calculatePossibleKeyLength();
    }

    private void calculateFriedmannIndex()
    {
        for (int i=0; i < 26; i++)
        {
            int currentOccurence = 0;
            String currentLetter = Alphabet.getLetterById(i).toUpperCase();
            if (occurrences.containsKey(currentLetter))
                currentOccurence = occurrences.get(currentLetter);

            friedmannIndex += (currentOccurence*(currentOccurence-1));
        }

        double textLength = message.length();
        friedmannIndex = friedmannIndex * (1/(textLength*(textLength-1)));

        System.out.println(friedmannIndex);
    }

    private void calculatePossibleKeyLength()
    {
        double textLength = message.length();
        possibleKeyLength = (textLength * (Ideutsch - IZufall)) / (friedmannIndex * (textLength-1) + Ideutsch - (textLength*IZufall));
    }

    public void printPossibleLengthWithFriedmann()
    {
        System.out.println("<----------------------------------------------------------------->");
        System.out.println("Friedmann Test: ");
        System.out.println("Friedmann Index: ");
        System.out.println("Friedmanns mögliche Schlüssellänge: " + possibleKeyLength);
    }

}
