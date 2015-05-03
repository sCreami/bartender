package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Groupe Q - Bartender
 */
public class Serveur {

    static ArrayList<Serveur> serveurs;

    /* Table bdd */
    public static final String DB_TABLE_SV = "Serveur";

    public static final String DB_COL_ID = "identifiant";
    public static final String DB_COL_NM = "nom";
    public static final String DB_COL_MP = "mdp";

    private int identifiant;
    private String nom;
    private String mdp;

    private static int numeroTable = 1;
    //Variables static pour savoir si on est connecté
    private static boolean isAdmin = false;

    public Serveur(int identifiant, String nom, String mdp) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.mdp = mdp;
    }

    /**
     *  Compare si le login et le password recu correspond a un administrateur.
     *  retourne 1 su la connection a réussi et 0 sinon.
     * TODO fix se connecter
    public int seConnecter(String login, String password) {
        for(int i = 0; i < Serveur.login.length; i++){
            if(Serveur.login[i].equals(login) && Serveur.password[i].equals(password)) {
                isAdmin = true;
                return 1;
            }
        }
        return 0;
    }
    */

    /**
     *  Déconnecte l'utilisateur
     */
    public void seDeconnecter() {
        isAdmin = false;
    }

    public boolean isConnect(){
        return isAdmin;
    }

    public static int getNumeroTable() {
        return numeroTable;
    }

    public static void setNumeroTable(int numeroTable) {
        Serveur.numeroTable = numeroTable;
    }

    public int getIdentifiant() { return identifiant; }

    public void setIdentifiant(int identifiant) { this.identifiant = identifiant; }

    public String getNom() { return nom; }

    public void setNom(String nom) {this.nom = nom; }

    public String getMotDePasse() { return mdp; }

    public void setMotDePasse(String motDePasse) { this.mdp = motDePasse; }

    @Override
    public String toString() {
        return "Serveur{" +
                "identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", motDePasse='" + mdp + '\'' +
                '}';
    }

    /* Partie static de la classe */

    private static SparseArray<Serveur> ServeurSparseArray = new SparseArray<Serveur>();

    public static ArrayList<Serveur> getServeurs() {

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COL_ID, DB_COL_NM, DB_COL_MP};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE_SV, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des boissons.
        serveurs = new ArrayList<Serveur>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de la boisson pour chaque ligne.
            int identifiant = cursor.getInt(0);
            String nom = cursor.getString(1);
            String mdp = cursor.getString(2);

            // Vérification pour savoir s'il y a déjà une instance de cet utilisateur.
            Serveur serveur = Serveur.ServeurSparseArray.get(identifiant);
            if (serveur == null) {
                // Si pas encore d'instance, création d'une nouvelle instance.
                serveur = new Serveur(identifiant, nom, mdp);
            }

            // Ajout de l'utilisateur à la liste.
            serveurs.add(serveur);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();

        return serveurs;
    }
}
