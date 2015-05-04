package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Groupe Q - Bartender
 */
public class Serveur {

    static ArrayList<Serveur> serveurs;

    /* Table bdd */
    private static final String DB_TABLE_SV = "Serveur";

    private static final String DB_COL_ID = "identifiant";
    private static final String DB_COL_NM = "nom";
    private static final String DB_COL_MP = "mdp";

    /* Attributs objet */
    private int identifiant;
    private String nom;
    private String mdp;

    public Serveur(int identifiant, String nom, String mdp) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.mdp = mdp;
    }

    /**
     *  Compare si le login et le password recu correspond a un administrateur.
     *  retourne 1 su la connection a réussi et 0 sinon.
     */
    public static int seConnecter(String login, String password) {

        for(int i = 0; i < serveurs.size(); i++)
        {
            if(serveurs.get(i).getNom().equals(login))
            {
                if(serveurs.get(i).getMotDePasse().equals(password))
                {
                    Bartender.connectedUser = login;
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     *  Déconnecte l'utilisateur
     */
    public static void seDeconnecter() {
        Bartender.connectedUser = null;
    }

    public static boolean isConnect(){
        return (Bartender.connectedUser != null);
    }

    public int getIdentifiant() { return identifiant; }

    public void setIdentifiant(int identifiant) { this.identifiant = identifiant; }

    public String getNom() { return nom; }

    public void setNom(String nom) {this.nom = nom; }

    public String getMotDePasse() { return mdp; }

    public void setMotDePasse(String motDePasse) { this.mdp = motDePasse; }

    /* Partie static de la classe */

    private static SparseArray<Serveur> ServeurSparseArray = new SparseArray<Serveur>();

    public static ArrayList<Serveur> getServeurs() { return serveurs; }

    public static void loadServeurs() {

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
    }
}
