package lsinf1225.groupeq.bartender;

/**
 * Groupe Q - Bartender
 */
public class Serveur {

    private int identifiant;
    private String nom;
    private String motDePasse;

    public Serveur(int identifiant, String nom, String motDePasse) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Serveur{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
