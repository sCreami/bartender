package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.ListIterator;

import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Created by oliviermartin on 28/04/15.
 */
public class Inventaire {

    /* Table bdd */
    private static final String DB_TABLE_BS = "Inventaire";

    private static final String DB_COL_NP = "numeroProduit";
    private static final String DB_COL_NB = "numeroBoisson";
    private static final String DB_COL_PX = "prix";
    private static final String DB_COL_FT = "format";
    private static final String DB_COL_SK = "stock";
    private static final String DB_COL_SL = "seuil";
    private static final String DB_COL_MX = "maxStock";

    /* Attributs objet */
    private int noProduit;
    private int noBoisson;
    private double prix;
    private String format;
    private int qteSeuil;
    private int qteMax;
    private int qteStock;

    /* Contient l'inventaire */
    public static ArrayList<Inventaire> inventaires;

    private Inventaire(int noProduit, int noBoisson, double prix, String format, int qteSeuil, int qteMax, int qteStock) {
        this.noProduit = noProduit;
        this.noBoisson = noBoisson;
        this.prix = prix;
        this.format = format;
        this.qteSeuil = qteSeuil;
        this.qteMax = qteMax;
        this.qteStock = qteStock;
    }

    /*
     *  ???
     */
    public static void alertAdmin(){

    }

    public void remplirInventaire(int quantitee){
        if(this.qteMax == this.qteStock)return;
        this.qteStock += quantitee;
    }

    public int viderInventaire(int quantitee){
        if(qteStock == 0)return 0;
        this.qteStock -= quantitee;
        return 1;
    }

    public int getNoProduit() {
        return noProduit;
    }

    public void setNoProduit(int noProduit) {
        this.noProduit = noProduit;
    }

    public int getNoBoisson() {
        return noBoisson;
    }

    public void setNoBoisson(int noBoisson) {
        this.noBoisson = noBoisson;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getQteSeuil() {
        return qteSeuil;
    }

    public void setQteSeuil(int qteSeuil) {
        this.qteSeuil = qteSeuil;
    }

    public int getQteMax() {
        return qteMax;
    }

    public void setQteMax(int qteMax) {
        this.qteMax = qteMax;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public static Inventaire getProduitFromNo(int no){

        // Techniquement ils sont dans l'ordre...
        return inventaires.get(no-1);

        /*
        for(int i = 0; i < inventaires.size(); i++)
            if(inventaires.get(i).noProduit == no)
                return inventaires.get(i);
        return null;
        */
    }


    /* Partie static de la classe */

    private static SparseArray<Inventaire> InventaireSparseArray = new SparseArray<Inventaire>();

    public static ArrayList<Inventaire> getInventaires() { return inventaires; }

    public static void loadInventaires() {

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COL_NP,DB_COL_NB,DB_COL_PX,DB_COL_FT,DB_COL_SK,DB_COL_SL,DB_COL_MX};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE_BS, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des boissons.
        inventaires = new ArrayList<Inventaire>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de la boisson pour chaque ligne.
            int noProduit = cursor.getInt(0);
            int noBoisson = cursor.getInt(1);
            double prix = cursor.getDouble(2);
            String format = cursor.getString(3);
            int qteStock = cursor.getInt(4);
            int qteSeuil = cursor.getInt(5);
            int qteMax = cursor.getInt(6);

            // Vérification pour savoir s'il y a déjà une instance de cet utilisateur.
            Inventaire inventaire = Inventaire.InventaireSparseArray.get(noProduit);
            if (inventaire == null) {
                // Si pas encore d'instance, création d'une nouvelle instance.
                inventaire = new Inventaire(noProduit, noBoisson, prix, format, qteSeuil, qteMax, qteStock);
            }

            // Ajout de l'utilisateur à la liste.
            inventaires.add(inventaire);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();
    }

}
