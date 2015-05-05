package lsinf1225.groupeq.bartender.activity;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        if(!getResources().getConfiguration().locale.toString().equals(Bartender.locale)) {
            setLocale(Bartender.locale);
            refreshActivity();
        }

        Button b = (Button)findViewById(R.id.buttonInventaire);
        if(Bartender.connectedUser == null)
            b.setVisibility(View.GONE);
        else
            b.setVisibility(View.VISIBLE);

        if(bddLoaded == false) {
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
            bddLoaded = true;
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

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        refreshActivity();
    }

    public void refreshActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
