package lsinf1225.groupeq.bartender.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Detail;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;
import lsinf1225.groupeq.bartender.models.Musique;
import lsinf1225.groupeq.bartender.models.Serveur;


public class MainActivity extends Activity {

    static boolean bddLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(bddLoaded == false) {

            Intent splash = new Intent(this,SplashActivity.class);
            startActivity(splash);

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

            Facture.factures = new ArrayList<Facture>();
            Facture.factureActuelle = new Facture(1, null, Bartender.table, "oli", 0, 0);
            Facture.factureActuelle.facDet = Detail.details;
            bddLoaded = true;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Button b = (Button)findViewById(R.id.buttonInventaire);
        if(Bartender.connectedUser == null)
            b.setVisibility(View.GONE);
        else
            b.setVisibility(View.VISIBLE);
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
