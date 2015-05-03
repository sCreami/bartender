package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Detail;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;
import lsinf1225.groupeq.bartender.models.Musique;
import lsinf1225.groupeq.bartender.models.Serveur;


public class MainActivity extends Activity {

    boolean ok = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        if(ok == false) {
            // Faut bien générer ça une fois !
            //Oui mais ca le racharge a chaque fois qu'on retourne au menu...!
            //J'ai ajouté un boolean ok pour lutter contre cela
            //On pourrait mettre cela dans la main aussi
            Boisson.loadBoissons();
            Detail.loadDetails();
            Facture.loadFactures();
            Inventaire.loadInventaires();
            Musique.loadMusiques();
            Serveur.loadServeurs();

            Facture.factureActuelle = new Facture(123, null, Bartender.table, "oli", 0, 0);
            ok = true;
        }
    }

    public void openCarte(View view)
    {
        Intent intent = new Intent(MainActivity.this, CarteActivity.class);
        startActivity(intent);
    }

    public void openFacture(View view)
    {
        Intent intent = new Intent(MainActivity.this, FactureActivity.class);
        startActivity(intent);
    }

    public void openMusique(View view)
    {
        Intent intent = new Intent(MainActivity.this, MusiqueActivity.class);
        startActivity(intent);
    }

    public void openInventaire(View view)
    {
        Intent intent = new Intent(MainActivity.this, InventaireActivity.class);
        startActivity(intent);
    }

    public void openOptions(View view)
    {
        Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
        startActivity(intent);
    }
}
