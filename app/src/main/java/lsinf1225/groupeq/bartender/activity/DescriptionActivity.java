package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Inventaire;

public class DescriptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        Intent myIntent = getIntent();
        String position = myIntent.getStringExtra("position");
        int pos = Integer.parseInt(position); // p-1

        Inventaire in = Inventaire.getProduitFromNo(pos+1);
        Boisson bo = Boisson.getBoissonFromNo(in.getNoBoisson());

        TextView nom = (TextView) findViewById(R.id.produitNom);
        TextView description = (TextView) findViewById(R.id.produitDescription);
        TextView format = (TextView) findViewById(R.id.produitFormat);
        TextView taux = (TextView) findViewById(R.id.produitTaux);
        TextView type = (TextView) findViewById(R.id.produitType);

        nom.setText(bo.getNom());
        description.setText(bo.getDescription());
        format.setText(in.getFormat());
        taux.setText(Double.toString(bo.getTauxAlcool()));
        type.setText(bo.getType());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
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
