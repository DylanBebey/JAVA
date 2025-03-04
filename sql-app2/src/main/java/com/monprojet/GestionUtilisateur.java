package com.monprojet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionUtilisateur {

    // Ajouter un utilisateur
    public void add(Connexion connect, Scanner sc) {
        if (connect.getConnexion() == null) {
            System.out.println("La connexion à la base de données a échoué. Veuillez vérifier la connexion.");
            return;
        }

        System.out.print("Nom de l'utilisateur : ");
        String lastName = sc.nextLine();

        System.out.print("Prénom de l'utilisateur : ");
        String firstName = sc.nextLine();

        System.out.print("Email de l'utilisateur : ");
        String email = sc.nextLine();

        try {
            String sqlInsert = "INSERT INTO utilisateurs (prenom, nom, email) VALUES (?, ?, ?)";
            PreparedStatement pstmtInsert = connect.getConnexion().prepareStatement(sqlInsert);
            pstmtInsert.setString(1, firstName);
            pstmtInsert.setString(2, lastName);
            pstmtInsert.setString(3, email);

            int rowsAffected = pstmtInsert.executeUpdate();
            System.out.println("Insertion réussie, lignes affectées : " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    // Lister tous les utilisateurs
    public void liste(Connexion connect) {
        if (connect.getConnexion() == null) {
            System.out.println("La connexion à la base de données a échoué. Veuillez vérifier la connexion.");
            return;
        }

        try {
            String sqlSelect = "SELECT * FROM utilisateurs";
            PreparedStatement pstmtSelect = connect.getConnexion().prepareStatement(sqlSelect);
            ResultSet rs = pstmtSelect.executeQuery();

            System.out.println("\nListe des utilisateurs :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");
                String email = rs.getString("email");

                System.out.println("ID: " + id + " | Nom: " + nom + " | Prénom: " + prenom + " | Email: " + email);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    // Supprimer un utilisateur par son ID
    public void supprimer(Connexion connect, Scanner sc) {
        if (connect.getConnexion() == null) {
            System.out.println("La connexion à la base de données a échoué. Veuillez vérifier la connexion.");
            return;
        }

        System.out.print("ID de l'utilisateur à supprimer : ");
        int id = sc.nextInt();
        sc.nextLine(); // Nettoyer le buffer

        try {
            String sqlDelete = "DELETE FROM utilisateurs WHERE id = ?";
            PreparedStatement pstmtDelete = connect.getConnexion().prepareStatement(sqlDelete);
            pstmtDelete.setInt(1, id);

            int rowsAffected = pstmtDelete.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur supprimé avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    // Modifier un utilisateur par son ID
    public void modifier(Connexion connect, Scanner sc) {
        if (connect.getConnexion() == null) {
            System.out.println("La connexion à la base de données a échoué. Veuillez vérifier la connexion.");
            return;
        }

        System.out.print("ID de l'utilisateur à modifier : ");
        int id = sc.nextInt();
        sc.nextLine(); // Nettoyer le buffer

        System.out.print("Nouveau prénom : ");
        String newPrenom = sc.nextLine();

        System.out.print("Nouveau nom : ");
        String newNom = sc.nextLine();

        System.out.print("Nouvel email : ");
        String newEmail = sc.nextLine();

        try {
            String sqlUpdate = "UPDATE utilisateurs SET prenom = ?, nom = ?, email = ? WHERE id = ?";
            PreparedStatement pstmtUpdate = connect.getConnexion().prepareStatement(sqlUpdate);
            pstmtUpdate.setString(1, newPrenom);
            pstmtUpdate.setString(2, newNom);
            pstmtUpdate.setString(3, newEmail);
            pstmtUpdate.setInt(4, id);

            int rowsAffected = pstmtUpdate.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Utilisateur mis à jour avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    // Chercher un utilisateur par son email
    public void chercher(Connexion connect, Scanner sc) {
        if (connect.getConnexion() == null) {
            System.out.println("La connexion à la base de données a échoué. Veuillez vérifier la connexion.");
            return;
        }

        System.out.print("Email de l'utilisateur à rechercher : ");
        String email = sc.nextLine();

        try {
            String sqlSearch = "SELECT * FROM utilisateurs WHERE email = ?";
            PreparedStatement pstmtSearch = connect.getConnexion().prepareStatement(sqlSearch);
            pstmtSearch.setString(1, email);

            ResultSet rs = pstmtSearch.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String prenom = rs.getString("prenom");
                String nom = rs.getString("nom");

                System.out.println("Utilisateur trouvé :");
                System.out.println("ID: " + id + " | Nom: " + nom + " | Prénom: " + prenom + " | Email: " + email);
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet email.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
}
