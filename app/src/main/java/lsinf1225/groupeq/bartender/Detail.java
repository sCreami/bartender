package lsinf1225.groupeq.bartender;

/**
 * Created by Quentin on 28/04/15.
 */
public class Detail {
    private int noFacture;
    private int noProduit;
    private int aLivre;
    private int dejaLivre;
    private int dejaPaye;

    public Detail(int noFacture, int noProduit,int aLivre, int dejaLivre, int dejaPaye){
        this.noFacture = noFacture;
        this.noProduit = noProduit;
        this.aLivre = aLivre;
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

    public int getaLivre() {
        return aLivre;
    }

    public void setaLivre(int aLivre) {
        this.aLivre = aLivre;
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

    public void ajouterBoissonToCommande(int noProduit){
        //
    }

    public void modifyStatutBoisson(int noProduit){
        //
    }

    public void payer(double montant){
        //
    }
}
