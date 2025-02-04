import java.util.Scanner;

public class Ask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String statut;

        System.out.println("Entrez votre nom : ");
        String nom = scanner.nextLine();

        System.out.println("Entrez votre age :");
        int age = scanner.nextInt();

        System.out.println("Bonjour " + nom + "!");

        if (age > 18) {
            statut = "Majeur";
        } else {
            statut = "Mineur";
            
        }
        
        System.out.println("Bonjour votre nom est " + nom + " et vous ètes " + statut);

        scanner.close();


    }
}
