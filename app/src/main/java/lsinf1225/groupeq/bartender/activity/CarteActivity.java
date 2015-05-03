package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.activity.adapter.CarteArrayAdapter;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Inventaire;


public class CarteActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Inventaire> inventaire = Inventaire.getInventaires();

        Inventaire[] carte = new Inventaire[inventaire.size()];
        carte = inventaire.toArray(carte);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        CarteArrayAdapter adapter = new CarteArrayAdapter(this, carte);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent myIntent = new Intent(this,DescriptionActivity.class);
        myIntent.putExtra("position",Integer.toString(position));
        startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_carte, menu);
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
}
