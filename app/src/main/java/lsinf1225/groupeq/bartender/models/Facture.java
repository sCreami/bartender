package lsinf1225.groupeq.bartender.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import lsinf1225.groupeq.bartender.models.Detail;

public class Facture {
	private int noFacture;
	private Date date;
	private int noTable;
	private int jetons;
	private boolean etat; // true = open, false = closed
	private String serveur;
	private double discount;
	private ArrayList<Detail> detail;
	
	
	public Facture(int noFacture, Date date, int noTable, String serveur) {
		super();
		this.noFacture = noFacture;
		this.date = date;
		this.noTable = noTable;
		this.serveur = serveur;
		this.etat = true;
		this.discount = 0;
		this.jetons = 0;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getNoFacture() {
		return noFacture;
	}
	public void setNoFacture(int noFacture) {
		this.noFacture = noFacture;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNoTable() {
		return noTable;
	}
	public void setNoTable(int noTable) {
		this.noTable = noTable;
	}
	public int getJetons() {
		return jetons;
	}
	public void setJetons(int jetons) {
		this.jetons = jetons;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public String getServeur() {
		return serveur;
	}
	public void setServeur(String serveur) {
		this.serveur = serveur;
	}

	public void addJetons(int ajout) {
		this.jetons += ajout;
	}

	public void removeJetons(int enleve) {
		this.jetons = this.jetons - enleve;
	}



	public void closeFacture() {
		this.etat = false;
	}

	/*
	 * Calcule le prix total a payer
	 */
    public double computePrice() {
        ListIterator<Detail> itr = this.detail.listIterator();
        double price = 0.0;

        while (itr.hasNext()){
            Detail dtl = itr.next();
            Inventaire inv = Inventaire.searchInventaire(dtl.getNoProduit());
            double montant = (inv.getPrix()*dtl.getDejaLivre());           //prix * quantite
            price += (montant-(montant*(discount/100)));                   //applique discount
        }
        return price;
	}
	
	/**
	 * 
	 * Si le produit noProduit existe déjà dans le tableau de détails, incrémente la quantité
	 * Si le produit noProduit n'existe pas encore, crée un nouvel objet détail et l'ajoute dans le tableau des détails
	 * 
	 * @param noProduit
	 * @param quantite
	 */
	public void addDetail(int noProduit, int quantite) {
        ListIterator<Detail> itr = this.detail.listIterator();
        boolean existe = false;             // le produit noProduit existe-t-il dans le tableau ?

        while (itr.hasNext()){              // Cherche le produit dans la liste
            Detail dtl = itr.next();
            if (dtl.getNoProduit() == noProduit) {
                dtl.setaLivrer((dtl.getaLivrer() + quantite));
                existe = true;
            }
        }
        if (existe == false){               // Si pas encore dans la liste, cree detail et l'ajoute
            //TODO savoir ce qui se passait ici
            //Detail newDtl = new Detail(this.noFacture, noProduit, quantite, 0, 0);
            //this.detail.add(newDtl);
        }
	}

	/**
	 * 
	 * Valide la livraison du produit noProduit
	 * Enlève pour le produit noProduit quantite de aLivrer et l'ajoute dans dejaLivre 
	 * 
	 * @param noProduit
	 * @param quantite
	 */
	public void validateLivraison (int noProduit, int quantite)  {
        ListIterator<Detail> itr = this.detail.listIterator();

        while (itr.hasNext()) {
            Detail dtl = itr.next();
            if (dtl.getNoProduit() == noProduit){
                dtl.ajouterBoissonToCommande(quantite);
            }
        }
	}

	/**
	 * 
	 * Valide le payement du produit noProduit
	 * Enlève pour le produit noProduit quantite de dejaLivre et l'ajoute dans dejaPaye 
	 * 
	 * @param noProduit
	 * @param quantite
	 */
	public void validatePayement (int noProduit, int quantite) {
        ListIterator<Detail> itr = this.detail.listIterator();

        while (itr.hasNext()) {
            Detail dtl = itr.next();
            if (dtl.getNoProduit() == noProduit){
                dtl.ajouterCommandeToFacture(quantite);
            }
        }
	}
}
