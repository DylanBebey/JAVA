import java.util.ArrayList;
import java.util.Scanner;

public class GestionEtudiants {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> etudiants = new ArrayList<>();
    

    public void Ajouter() {
        System.out.print("Veuillez saisir le nom de l'etudiant : ");
        nom = scanner.nextLine();

        System.out.print("Veuillez saisir le prenom de l'etudiant :");
        prenom = scanner.nextLine();

        System.out.print("Veuillez saisir la classe de l'etudiant : ");
        classe = scanner.nextLine();
    }


}
