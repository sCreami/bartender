package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.activity.adapter.CarteArrayAdapter;
import lsinf1225.groupeq.bartender.activity.adapter.InventaireArrayAdapter;
import lsinf1225.groupeq.bartender.models.Inventaire;


public class InventaireActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Inventaire> inventaireAL = Inventaire.getInventaires();

        // Besoin d'un tableau pour l'adaptateur sinon c'est dégeulasse
        Inventaire[] inventaire = new Inventaire[inventaireAL.size()];
        inventaire = inventaireAL.toArray(inventaire);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        InventaireArrayAdapter adapter = new InventaireArrayAdapter(this, inventaire);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Inventaire.getInventaires().get(position).remplirInventaire(1);
        Toast.makeText(InventaireActivity.this, Inventaire.getInventaires().get(position).getQteMax(), Toast.LENGTH_SHORT).show();

        ArrayList<Inventaire> inventaireAL = Inventaire.getInventaires();

        // Besoin d'un tableau pour l'adaptateur sinon c'est dégeulasse
        Inventaire[] inventaire = new Inventaire[inventaireAL.size()];
        inventaire = inventaireAL.toArray(inventaire);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        InventaireArrayAdapter adapter = new InventaireArrayAdapter(this, inventaire);

        setListAdapter(adapter);

    }
}
