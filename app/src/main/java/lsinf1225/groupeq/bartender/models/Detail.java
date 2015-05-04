package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Created by Quentin on 28/04/15.
 */
public class Detail {

    public static ArrayList<Detail> details;

    /* Table bdd */
    public static final String DB_TABLE_DT = "Detail";

    private static final String DB_COL_RW = "rowid";
    private static final String DB_COL_NF = "numeroFacture";
    private static final String DB_COL_NP = "numeroProduit";
    private static final String DB_COL_AL = "aLivre";
    private static final String DB_COL_DL = "dejaLivre";
    private static final String DB_COL_DP = "dejaPaye";

    /* Attributs objet */
    private int rowid;
    private int noFacture;
    private int noProduit;
    private int aLivrer;
    private int dejaLivre;
    private int dejaPaye;

    public Detail(int rowid,int noFacture, int noProduit,int aLivrer, int dejaLivre, int dejaPaye){
        this.rowid = rowid;
        this.noFacture = noFacture;
        this.noProduit = noProduit;
        this.aLivrer = aLivrer;
        this.dejaLivre = dejaLivre;
        this.dejaPaye = dejaPaye;
    }

    public int getNoFacture() {
        return noFacture;
    }

    public void setNoFacture(int noFacture) {
        this.noFacture = noFacture;
    }

    public int getNoProduit() {
        return noProduit;
    }

    public void setNoProduit(int noProduit) {
        this.noProduit = noProduit;
    }

    public int getaLivrer() {
        return aLivrer;
    }

    public void setaLivrer(int aLivrer) {
        this.aLivrer = aLivrer;
    }

    public int getDejaLivre() {
        return dejaLivre;
    }

    public void setDejaLivre(int dejaLivre) {
        this.dejaLivre = dejaLivre;
    }

    public int getDejaPaye() {
        return dejaPaye;
    }

    public void setDejaPaye(int dejaPaye) {
        this.dejaPaye = dejaPaye;
    }

    public void ajouterBoissonToCommande(int quantite){
        this.aLivrer -= quantite;
        this.dejaLivre += quantite;
    }

    public void ajouterCommandeToFacture(int quantite){
        this.dejaLivre -= quantite;
        this.dejaPaye += quantite;
    }

    public void modifyStatutBoisson(int ajouter, int retirer){
        this.aLivrer += ajouter;
        this.aLivrer -= retirer;
    }

    public void payer(double montant){
        // A quoi sert cette methode ??? (= ajouterCommandeToFacture ???)
    }

    /* Partie static de la classe */

    private static SparseArray<Detail> DetailSparseArray = new SparseArray<Detail>();

    public static ArrayList<Detail> getDetails() { return details; }

    public static void loadDetails() {

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COL_RW,DB_COL_NF,DB_COL_NP,DB_COL_AL,DB_COL_DL,DB_COL_DP};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE_DT, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des boissons.
        details = new ArrayList<Detail>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de la boisson pour chaque ligne.
            int rowid = cursor.getInt(0);
            int noFacture = cursor.getInt(1);
            int noProduit = cursor.getInt(2);
            int aLivrer = cursor.getInt(3);
            int dejaLivre = cursor.getInt(4);
            int dejaPaye = cursor.getInt(5);

            // Vérification pour savoir s'il y a déjà une instance de cet utilisateur.
            Detail detail = Detail.DetailSparseArray.get(rowid);
            if (detail == null) {
                // Si pas encore d'instance, création d'une nouvelle instance.
                detail = new Detail(rowid, noFacture, noProduit, aLivrer, dejaLivre, dejaPaye);
            }

            // Ajout de l'utilisateur à la liste.
            details.add(detail);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();
    }

}
