package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.LinkedList;

import lsinf1225.groupeq.bartender.MySQLiteHelper;

/**
 * Groupe Q - Bartender
 */
public class Musique {

    static ArrayList<Musique> musiques;

    /* Table bdd */
    public static final String DB_TABLE_MS = "Musique";

    private static final String DB_COL_NO = "numeroMusique";
    private static final String DB_COL_TT = "titre";
    private static final String DB_COL_AR = "artiste";
    private static final String DB_COL_GN = "genre";
    private static final String DB_COL_AN = "annee";

    /* Attributs objet */
    private int noMusique;
    private String titre;
    private String artiste;
    private String genre;
    private int annee;

    /* todo expliquer ce que c'est */
    private LinkedList<Boisson> playlist;

    public Musique(int noMusique, String titre, String artiste, String genre, int annee){
        this.noMusique = noMusique;
        this.titre = titre;
        this.artiste = artiste;
        this.genre = genre;
        this.annee = annee;
    }

    public int getNoMusique() {
        return noMusique;
    }

    public void setNoMusique(int noMusique) {
        this.noMusique = noMusique;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void createPlaylist(){
        this.playlist = new LinkedList<Boisson>();
    }

    public void push(Boisson boisson){
        this.playlist.add(boisson);
    }

    public Boisson pop(){
        return this.playlist.poll();
    }


    /* Partie static de la classe */

    private static SparseArray<Musique> MusiqueSparseArray = new SparseArray<Musique>();

    public static ArrayList<Musique> getMusiques() { return musiques; }

    public static void loadMusiques() {

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COL_NO, DB_COL_TT, DB_COL_AR, DB_COL_GN, DB_COL_AN};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE_MS, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des boissons.
        musiques = new ArrayList<Musique>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de la boisson pour chaque ligne.
            int noMusique = cursor.getInt(0);
            String titre = cursor.getString(1);
            String artiste = cursor.getString(2);
            String genre = cursor.getString(3);
            int annee = cursor.getInt(4);


            // Vérification pour savoir s'il y a déjà une instance de cet utilisateur.
            Musique musique = Musique.MusiqueSparseArray.get(noMusique);
            if (musique == null) {
                // Si pas encore d'instance, création d'une nouvelle instance.
                musique = new Musique(noMusique, titre, artiste, genre, annee);
            }

            // Ajout de l'utilisateur à la liste.
            musiques.add(musique);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();
    }
}
