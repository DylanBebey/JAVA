package com.monprojet;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World !");

        // Créer la connexion
        Connexion connexion = new Connexion();

        // Vérifier si la connexion est bien établie
        if (connexion.getConnexion() == null) {
            System.out.println("Impossible de se connecter à la base de données. L'application va se fermer.");
            System.exit(1); // Quitter l'application si la connexion échoue
        }

        int choix;
        Scanner sc = new Scanner(System.in);
        GestionUtilisateur gu = new GestionUtilisateur();

        do {
            System.out.println("\nQue voulez-vous faire ?");
            System.out.println("1 - Ajouter un utilisateur");
            System.out.println("2 - Lister les utilisateurs");
            System.out.println("3 - Supprimer un utilisateur");
            System.out.println("4 - Modifier un utilisateur");
            System.out.println("5 - Chercher un utilisateur");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // Pour éviter les problèmes avec nextInt()

            switch (choix) {
                case 1:
                    gu.add(connexion, sc);
                    break;
                case 2:
                    gu.liste(connexion);
                    break;
                case 3:
                    gu.supprimer(connexion, sc);
                    break;
                case 4:
                    gu.modifier(connexion, sc);
                    break;
                case 5:
                    gu.chercher(connexion, sc);
                    break;
                case 0:
                    System.out.println("Fermeture de l'application...");
                    break;
                default:
                    System.out.println("L'action demandée n'existe pas !");
            }
        } while (choix != 0);

        // Fermer la connexion et le scanner proprement
        connexion.close();
        sc.close();
        System.exit(0); // Terminer l'application proprement
    }
}
