package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.activity.adapter.CarteArrayAdapter;
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
        CarteArrayAdapter adapter = new CarteArrayAdapter(this, inventaire);

        setListAdapter(adapter);
    }

}
