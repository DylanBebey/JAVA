package com.monprojet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    String url = "jdbc:mysql://localhost:5222/mabasegr2";  // Remplace par ton URL de base de données
    String utilisateur = "root";  // Remplace par ton nom d'utilisateur
    String motDePasse = "";  // Remplace par ton mot de passe
    Connection connexion = null;

    public Connexion() {
        try {
            // Établir la connexion
            this.connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            // La connexion échoue ici et la variable `connexion` reste null.
        }
    }

    // Méthode pour obtenir la connexion à la base de données
    public Connection getConnexion() {
        return this.connexion;
    }

    // Méthode pour fermer la connexion
    public void close() {
        if (this.connexion != null) { 
            try { 
                this.connexion.close(); 
                System.out.println("Connexion fermée avec succès."); 
            } catch (SQLException e) { 
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage()); 
            } 
        } 
    }
}
