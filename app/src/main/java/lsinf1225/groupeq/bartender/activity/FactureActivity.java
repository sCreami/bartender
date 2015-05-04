package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        final List<String> exemple = new ArrayList<String>();
        load(exemple);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemple);
        liste.setAdapter(adapter);

        noTable = (TextView)findViewById(R.id.factureTable);
        noTable.setText("Table " + Bartender.table);

        prixFacture = (TextView)findViewById(R.id.facturePrix);
        prixFacture.setText("" + Facture.factureActuelle.computePrice() + " €");

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                //Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
                //i.putExtra("id", position);
                //startActivity(i);
                Toast.makeText(FactureActivity.this, "Payement " + position, Toast.LENGTH_SHORT).show();
                prixFacture.setText("" + Facture.factureActuelle.computePrice() + " €");

                Detail.details.get(position / 2).ajouterCommandeToFacture(1);
                Intent intent = new Intent(FactureActivity.this, FactureActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }

    private void load(List<String> exemple){
        for(int i = 0; i < Detail.details.size(); i++)
        {
            Detail det = Detail.details.get(i);
            Inventaire inv = Inventaire.getProduitFromNo(det.getNoProduit());
            Boisson boi = Boisson.getBoissonFromNo(inv.getNoBoisson());
            exemple.add(boi.getNom() + " " + inv.getFormat() + " cl");
            exemple.add(det.getaLivrer() + " / " + det.getDejaLivre() + "      " + inv.getPrix() + " €");
        }
    }

}
