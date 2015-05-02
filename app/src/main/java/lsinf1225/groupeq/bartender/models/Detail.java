package lsinf1225.groupeq.bartender.models;

/**
 * Created by Quentin on 28/04/15.
 */
public class Detail {
    private int noFacture;
    private int noProduit;
    private int aLivrer;
    private int dejaLivre;
    private int dejaPaye;

    public Detail(int noFacture, int noProduit,int aLivrer, int dejaLivre, int dejaPaye){
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
}
