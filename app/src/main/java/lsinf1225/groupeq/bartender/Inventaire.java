package lsinf1225.groupeq.bartender;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by oliviermartin on 28/04/15.
 */
public class Inventaire {

    private int noProduit;
    private int noBoisson;
    private double prix;
    private String format;
    private int qteSeuil;
    private int qteMax;
    private int qteStock;
    private Boisson boisson; //Référence vers la boisson

    private static ArrayList<Inventaire> listeInventaire; //Liste qui contient touts les boissons
                                                    //ex : [Coca 33, Coca 50, Eau, Jupiler]

    public Inventaire(int noProduit, int noBoisson, double prix, String format, int qteSeuil, int qteMax, int qteStock, Boisson boisson) {
        this.noProduit = noProduit;
        this.noBoisson = noBoisson;
        this.prix = prix;
        this.format = format;
        this.qteSeuil = qteSeuil;
        this.qteMax = qteMax;
        this.qteStock = qteStock;
        this.boisson = boisson;
        //Chaque fois qu'on crée un Inventaire, on l'inventaire à la listeInventaire;
        listeInventaire.add(this);
    }

    /*
     *  ???
     */
    public static void alertAdmin(){

    }

    /*
     *  return : ArrayList<Inventaire> de toutes les Inventaires
     */
    public static ArrayList<Inventaire> getListOfBoisson(){
        return listeInventaire;
    }

    /*
     *  noProduit : identifiant d'un inventaire
     *  return : l'Inventaire qui a le noProduit souhaité. null si rien n'est trouvé.
     */
    public static Inventaire searchInventaire(int noProduit){
        ListIterator<Inventaire> itr = Inventaire.listeInventaire.listIterator();
        while (itr.hasNext()){
            Inventaire inv = itr.next();
            if(inv.getNoProduit() == noProduit)
                return inv;
        }
        return null;
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
}
