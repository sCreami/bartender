package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Detail;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;
import lsinf1225.groupeq.bartender.models.Serveur;


public class FactureActivity extends Activity {

    GridView liste = null;
    TextView prixFacture = null;
    TextView noTable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture);


        liste = (GridView) findViewById(R.id.factureView);
        List<String> exemple = new ArrayList<String>();

        for(int i = 0; i < Facture.factureActuelle.getDetail().size(); i++)
        {
            Detail det = Facture.factureActuelle.getDetail().get(i);

            Inventaire inv = Inventaire.searchInventaire(det.getNoProduit());
            Boisson boi = Inventaire.searchBoisson(inv.getNoBoisson());
            exemple.add(boi.getNom() + " " + inv.getFormat() + " cl");
            exemple.add(det.getaLivrer() + " / " + det.getDejaLivre() + "      " + inv.getPrix() + " €");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemple);
        liste.setAdapter(adapter);

        noTable = (TextView)findViewById(R.id.factureTable);
        noTable.setText("Table " + Bartender.table);

        prixFacture = (TextView)findViewById(R.id.facturePrix);
        prixFacture.setText("" + Facture.factureActuelle.computePrice() + " €");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_facture, menu);
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
