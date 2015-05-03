package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Detail;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;
import lsinf1225.groupeq.bartender.models.Musique;
import lsinf1225.groupeq.bartender.models.Serveur;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        // Faut bien générer ça une fois !
        Boisson.loadBoissons();
        Detail.loadDetails();
        Facture.loadFactures();
        Inventaire.loadInventaires();
        Musique.loadMusiques();
        Serveur.loadServeurs();

        Facture.factureActuelle = new Facture(123, null, Serveur.getNumeroTable(), "oli", 0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
