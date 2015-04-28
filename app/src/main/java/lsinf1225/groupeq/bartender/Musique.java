package lsinf1225.groupeq.bartender;

import java.util.LinkedList;

/**
 * Groupe Q - Bartender
 */
public class Musique {

    private int noMusique;
    private String titre;
    private String artiste;
    private String genre;
    private int annee;
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

    public void createPlaylist(LinkedList<Boisson> playlist){
        this.playlist = new LinkedList<Boisson>();
    }

    public void push(Boisson boisson){
        this.playlist.add(boisson);
    }

    public Boisson pop(){
        return this.playlist.poll();
    }
}
