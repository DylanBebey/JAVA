public class Etudiant {
    private String nom;
    private String prenom;
    private String classe;

public Etudiant(String pnom, String pprenom, String pclasse) {
    this.nom = pnom;
    this.prenom = pprenom;  
    this.classe = pclasse;

}

// Getter pour pouvoir récupérer les infos de l'étudiant 
    @Override 
    public String toString() {
        return this.nom + " " + this.prenom + " en " + this.classe;
    }

// Setter pour pouvoir modifier les infos de l'étudiant suivant son nom 

}