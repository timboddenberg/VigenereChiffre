import java.util.Scanner;

public class Vigenere
{
    public static void main(String[] args)
    {
        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Soll [d]Entschlüsselt oder [e]Verschlüsselt werden ?");

        String decision = scanner.nextLine();

        if (decision.equals("d")){

            System.out.println("geben Sie den Key ein: ");
            decryption.setKey(scanner.nextLine());

            System.out.println("geben Sie die Message ein: ");
            decryption.setMessage(scanner.nextLine());

            if (decryption.getKey().equals(""))
            {
                OccurenceAnalysis analysis = new OccurenceAnalysis();
                analysis.setMessage(decryption.getMessage());
                analysis.analyzeOccurences();
                analysis.sortLettersByOccurence();
                analysis.printAnalyzedResult();
            }
            else
                {
                    decryption.AdjustKeyToMessageLength();
                    decryption.DecriptMessage();
                    System.out.println("Entschlüsselte Nachricht: ");
                    System.out.println(decryption.getDecryptedMessage());
                }
        }
        else if (decision.equals("e")) {

            System.out.println("geben Sie den Key ein: ");
            encryption.setKey(scanner.nextLine());

            System.out.println("geben Sie die Message ein: ");
            encryption.setMessage(scanner.nextLine());

            encryption.AdjustKeyToMessageLength();
            encryption.EncryptMessage();

            System.out.println("Verschlüsselte Nachricht: ");
            System.out.println(encryption.getEncryptedMessage());

        }


    }


}
