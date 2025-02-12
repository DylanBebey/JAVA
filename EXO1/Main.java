package EXO1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Voiture voiture = new Voiture();
        
        System.out.println("Veuillez saisir la marque de votre voiture :");
        voiture.marque = scanner.nextLine();

        System.out.println("Veuillez saisir le modele de votre voiture :");
        voiture.modele = scanner.nextLine();

        System.out.println("Veuillez saisir la couleur de votre voiture :");
        voiture.couleur = scanner.nextLine();
        

        voiture.demarer();
    }
}
