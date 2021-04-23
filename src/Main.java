import Analyse.Friedmann;
import Analyse.Kasisky;
import Cryption.Decryption;
import Cryption.Encryption;
import Analyse.OccurenceAnalysis;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] Vorkommensanalyse");
        System.out.println("[2] Vigenere Verschlüsselung");
        System.out.println("[3] Vigenere Entschlüsselung mit key");
        System.out.println("[4] Vigenere Entschlüsselung ohne key");

        String decision = scanner.nextLine();

        Decryption decryption = new Decryption();
        Encryption encryption = new Encryption();

        String message;
        String key;

        switch (decision)
        {
            // Vorkommensanalyse
            case "1":
                System.out.println("geben Sie die Message ein: ");
                message = scanner.nextLine();
                decryption.setMessage(message);

                OccurenceAnalysis analysis = new OccurenceAnalysis(decryption.getMessage());
                analysis.analyzeMostUsedLetter(true);

            break;
            // Vigenere Verschlüsselung
            case "2":
                System.out.println("geben Sie die Message ein: ");
                message = scanner.nextLine();
                encryption.setMessage(message);

                System.out.println("geben Sie den Key ein: ");
                key = scanner.nextLine();
                encryption.setKey(key);

                encryption.EncryptMessage(true);
            break;
            // Vigenere Entschlüsselung mit key
            case "3":
                System.out.println("geben Sie den Key ein: ");
                key = scanner.nextLine();

                System.out.println("geben Sie die Message ein: ");
                message = scanner.nextLine();

                decryption.setKey(key);
                decryption.setMessage(message);
                decryption.DecriptMessage(true);
            break;
            case "4":
                System.out.println("geben Sie die Message ein: ");
                message = scanner.nextLine();
                Kasisky kasiskyAnalyse = new Kasisky(message);

                Friedmann friedmann = new Friedmann(message);
                friedmann.printPossibleLengthWithFriedmann();
            break;
        }


    }
}
