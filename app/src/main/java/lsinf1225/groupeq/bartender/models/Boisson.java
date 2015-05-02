package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.media.Image;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Groupe Q - Bartender
 */

public class Boisson {

    /* Table bdd */
    public static final String DB_TABLE_BS = "Boisson";

    public static final String DB_COL_NO = "numeroBoisson";
    public static final String DB_COL_NM = "nom";
    public static final String DB_COL_TA = "tauxAlcool";
    public static final String DB_COL_DS = "description";
    public static final String DB_COL_TY = "type";
    public static final String DB_COL_PH = "photo";

    /* pour éviter la confusion */
    public static final String DB_COL_BS_ID = DB_TABLE_BS + "." + DB_COL_NO;

    //"SELECT B.nom, B.tauxAlcool, B.description, B.type, I.prix, I.format FROM Boisson B, Inventaire I WHERE I.numeroBoisson = B.numeroBoisson"


    /* Models Boisson */
    private int noBoisson;
    private String nom;
    private double tauxAlcool;
    private String description;
    private Bitmap photo;
    private String type;

    public Boisson(int noBoisson, String nom, double tauxAlcool, String description, Bitmap photo, String type) {
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

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
