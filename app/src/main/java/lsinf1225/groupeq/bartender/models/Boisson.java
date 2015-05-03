package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.media.Image;
import android.util.SparseArray;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Groupe Q - Bartender
 */

public class Boisson {

    static ArrayList<Boisson> boissons;

    /* Table bdd */
    public static final String DB_TABLE_BS = "Boisson";

    private static final String DB_COL_NO = "numeroBoisson";
    private static final String DB_COL_NM = "nom";
    private static final String DB_COL_TA = "tauxAlcool";
    private static final String DB_COL_DS = "description";
    private static final String DB_COL_TY = "type";
    private static final String DB_COL_PH = "photo";

    /* Attributs objet */
    private int noBoisson;
    private String nom;
    private double tauxAlcool;
    private String description;
    private String photo;
    private String type;

    public Boisson(int noBoisson, String nom, double tauxAlcool, String description, String photo, String type) {
        this.noBoisson = noBoisson;
        this.nom = nom;
        this.tauxAlcool = tauxAlcool;
        this.description = description;
        this.photo = photo;
        this.type = type;
    }

    public int getNoBoisson() {
        return noBoisson;
    }

    public void setNoBoisson(int noBoisson) {
        this.noBoisson = noBoisson;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTauxAlcool() {
        return tauxAlcool;
    }

    public void setTauxAlcool(double tauxAlcool) {
        this.tauxAlcool = tauxAlcool;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Boisson getBoissonFromNo(int no) {

        // Techniquement ils sont dans l'ordre...
        return boissons.get(no);

        /*
        for(int i = 0; i < boissons.size(); i++)
            if(boissons.get(i).noBoisson == no)
                return boissons.get(i);
        return null;
        */
    }


    /* Partie static de la classe */

    private static SparseArray<Boisson> BoissonSparseArray = new SparseArray<Boisson>();

    public static ArrayList<Boisson> getBoissons() { return  boissons; }

    public static void loadBoissons() {

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COL_NO, DB_COL_NM, DB_COL_TA, DB_COL_DS, DB_COL_TY, DB_COL_PH};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE_BS, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des boissons.
        boissons = new ArrayList<Boisson>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de la boisson pour chaque ligne.
            int noBoisson = cursor.getInt(0);
            String nom = cursor.getString(1);
            double tauxAlcool = cursor.getDouble(2);
            String description = cursor.getString(3);
            String photo = cursor.getString(5);
            String type = cursor.getString(4);

            // Vérification pour savoir s'il y a déjà une instance de cet utilisateur.
            Boisson boisson = Boisson.BoissonSparseArray.get(noBoisson);
            if (boisson == null) {
                // Si pas encore d'instance, création d'une nouvelle instance.
                boisson = new Boisson(noBoisson,nom,tauxAlcool,description,photo,type);
            }

            // Ajout de l'utilisateur à la liste.
            boissons.add(boisson);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();
    }

}
