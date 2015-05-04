package lsinf1225.groupeq.bartender.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import lsinf1225.groupeq.bartender.MySQLiteHelper;
import lsinf1225.groupeq.bartender.models.Detail;

public class Facture {

    static ArrayList<Facture> factures;

    /* Table bdd */
    public static final String DB_TABLE_FT = "Facture";

    private static final String DB_COL_NF = "numeroFacture";
    private static final String DB_COL_ET = "etat";
    private static final String DB_COL_JT = "jetons";
    private static final String DB_COL_NT = "numeroTable";
    private static final String DB_COL_DT = "date";
    private static final String DB_COL_SV = "serveur";

    /* Attributs objet */
    private int noFacture;
	private String date;
	private int noTable;
    private String serveur;
    private int etat; // 0 = open, 1 = closed
	private int jetons;
	private double discount;

    public static Facture factureActuelle;

	public Facture(int noFacture, String date, int noTable, String serveur, int etat, int jetons) {
		this.noFacture = noFacture;
		this.date = date;
		this.noTable = noTable;
		this.serveur = serveur;
		this.etat = etat;
		this.discount = 0;
		this.jetons = 0;
        Facture.factureActuelle = this;
		this.jetons = jetons;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public boolean isOpen() {  return (etat == 0 ? true : false); }

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
		this.etat = 1;
	}

	/*
	 * Calcule le prix total a payer
	 */
    public double computePrice() {
        ListIterator<Detail> itr = Detail.details.listIterator();
        double price = 0.0;

        while (itr.hasNext()){
            Detail dtl = itr.next();
            Inventaire inv = Inventaire.getProduitFromNo(dtl.getNoProduit());
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
	public int addDetail(int noProduit, int quantite) {
        ListIterator<Detail> itr = Detail.details.listIterator();
        boolean existe = false;             // le produit noProduit existe-t-il dans le tableau ?
        if(Inventaire.getProduitFromNo(noProduit).viderInventaire(1) == 0)return 0;

        while (itr.hasNext()){              // Cherche le produit dans la liste
            Detail dtl = itr.next();
            if (dtl.getNoProduit() == noProduit) {
                dtl.setaLivrer((dtl.getaLivrer() + quantite));
                existe = true;
                return 1;
            }
        }
        if (existe == false){               // Si pas encore dans la liste, cree detail et l'ajoute
            Detail newDtl = new Detail(0,this.noFacture, noProduit, quantite, 0, 0);
            Detail.details.add(newDtl);
        }
        return 2;
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
        ListIterator<Detail> itr = Detail.details.listIterator();

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
        ListIterator<Detail> itr = Detail.details.listIterator();

        while (itr.hasNext()) {
            Detail dtl = itr.next();
            if (dtl.getNoProduit() == noProduit){
                dtl.ajouterCommandeToFacture(quantite);
            }
        }
	}

    /* Partie static de la classe */

    private static SparseArray<Facture> FactureSparseArray = new SparseArray<Facture>();

    public static ArrayList<Facture> getFactures() { return factures; }

    public static void loadFactures() {

        // Récupération du  SQLiteHelper et de la base de données.
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();

        // Colonnes à récupérer
        String[] colonnes = {DB_COL_NF, DB_COL_ET, DB_COL_JT, DB_COL_NT, DB_COL_DT, DB_COL_SV};

        // Requête de selection (SELECT)
        Cursor cursor = db.query(DB_TABLE_FT, colonnes, null, null, null, null, null);

        // Placement du curseur sur la première ligne.
        cursor.moveToFirst();

        // Initialisation la liste des boissons.
        factures = new ArrayList<Facture>();

        // Tant qu'il y a des lignes.
        while (!cursor.isAfterLast()) {
            // Récupération des informations de la boisson pour chaque ligne.
            int noFacture = cursor.getInt(0);
            int etat = cursor.getInt(1);
            int jetons = cursor.getInt(2);
            int noTable = cursor.getInt(3);
            String date = cursor.getString(4);
            String serveur = cursor.getString(5);

            // Vérification pour savoir s'il y a déjà une instance de cet utilisateur.
            Facture facture = Facture.FactureSparseArray.get(noFacture);
            if (facture == null) {
                // Si pas encore d'instance, création d'une nouvelle instance.
                facture = new Facture(noFacture, date, noTable, serveur, etat, jetons);
            }

            // Ajout de l'utilisateur à la liste.
            factures.add(facture);

            // Passe à la ligne suivante.
            cursor.moveToNext();
        }

        // Fermeture du curseur et de la base de données.
        cursor.close();
        db.close();
    }

}
