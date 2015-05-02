package lsinf1225.groupeq.bartender.models;

/**
 * Groupe Q - Bartender
 */
public class Serveur {

    private int identifiant;
    private String nom;
    private String motDePasse;

    //Variables static pour savoir si on est connecté
    private static boolean isAdmin = false;
    //Les deux tableaux devront être crées grâce aux data de la BD
    //Hardcode en attendant
    private static final String[] login = {"oli", "alexis", "denis", "quentin"};
    private static final String[] password = {"mdp", "mdp", "mdp", "mdp"};

    public Serveur(int identifiant, String nom, String motDePasse) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    /**
     *  Compare si le login et le password recu correspond a un administrateur.
     *  retourne 1 su la connection a réussi et 0 sinon.
     */
    public int seConnecter(String login, String password) {
        for(int i = 0; i < Serveur.login.length; i++){
            if(Serveur.login[i].equals(login) && Serveur.password[i].equals(password)) {
                isAdmin = true;
                return 1;
            }
        }
        return 0;
    }

    /**
     *  Déconnecte l'utilisateur
     */
    public void seDeconnecter() {
        isAdmin = false;
    }

    public boolean isConnect(){
        return isAdmin;
    }

    public int getIdentifiant() { return identifiant; }

    public void setIdentifiant(int identifiant) { this.identifiant = identifiant; }

    public String getNom() { return nom; }

    public void setNom(String nom) {this.nom = nom; }

    public String getMotDePasse() { return motDePasse; }

    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    @Override
    public String toString() {
        return "Serveur{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
