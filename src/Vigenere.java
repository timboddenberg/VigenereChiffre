import Cryption.Decryption;
import Cryption.Encryption;
import Helpers.OccurenceAnalysis;

import java.util.Scanner;

public class Vigenere
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Soll [d]Entschlüsselt oder [e]Verschlüsselt werden ?");

        String decision = scanner.nextLine();

        System.out.println("geben Sie den Key ein: ");
        String key = scanner.nextLine();

        System.out.println("geben Sie die Message ein: ");
        String message = scanner.nextLine();

        // Entschlüsselung
        if (decision.equals("d")){
            Decryption decryption = new Decryption();
            decryption.setKey(key);
            decryption.setMessage(message);

            // Analyse bei fehlendem Key
            if (decryption.getKey().equals(""))
            {
                OccurenceAnalysis analysis = new OccurenceAnalysis(decryption.getMessage());
                analysis.analyzeMostUsedLetter(true);
            }
            else
                {
                    decryption.DecriptMessage(true);
                }
        }
        // Verschlüsselung
        else if (decision.equals("e")) {
            Encryption encryption = new Encryption();

            encryption.setKey(key);
            encryption.setMessage(message);

            encryption.EncryptMessage(true);
        }
    }
}
