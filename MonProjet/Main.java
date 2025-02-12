import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement du programme - v1");
        int choix = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Que voulez vous faire");
            System.out.println("1 - Ajouter un Etudiant");
            System.out.println("2 - Supprimer un Etudiant");
            System.out.println("3 - Quitter");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Pour ajouter un étudiant");   
                    break;
                case 2:
                    System.out.println("Pour supprimer un étudiant");
                    break;
                case 3:
                    System.out.println("Pour Afficher un étudiant");
                    break;
                case 4:
                    System.out.println(" Au revoir !");
                    break;
            
                default:
                    System.out.println(" Choix non valide ");
                    break;
            }
        
        } while (choix != 4);
        sc.close();
    }
    
}
