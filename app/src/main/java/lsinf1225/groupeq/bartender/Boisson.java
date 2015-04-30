package lsinf1225.groupeq.bartender;

import android.graphics.Bitmap;
import android.media.Image;

/**
 * Groupe Q - Bartender
 */

public class Boisson {

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

    public String getDescription() {
        return description;
    }

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
