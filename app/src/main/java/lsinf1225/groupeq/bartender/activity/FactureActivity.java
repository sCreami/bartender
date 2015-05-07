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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Detail;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;
import lsinf1225.groupeq.bartender.models.Serveur;


public class FactureActivity extends Activity {

    static GridView liste;
    static TextView prixFacture;
    static TextView noTable;
    static TextView jetonsFacture;

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
        prixFacture.setText("" + String.format("%.2f",Facture.factureActuelle.computePrice()) + " €");

        jetonsFacture = (TextView)findViewById(R.id.factureJetons);
        jetonsFacture.setText("" + Facture.factureActuelle.getJetons());

        liste.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FactureActivity.this, DescriptionActivity.class);

                for(int i = 0; i < Inventaire.getInventaires().size(); i++){
                    if(Facture.factureActuelle.facDet.get(position / 2).getNoProduit() == Inventaire.getInventaires().get(i).getNoProduit()) {
                        intent.putExtra("position", Integer.toString(i));
                        break;
                    }
                }
                startActivity(intent);
                return true;
            }
        });

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View v,
                                    int position, long id) {
            if(position %2 == 0) {//Sion clique sur le nom
                    if (Bartender.connectedUser == null) {
                        Toast.makeText(FactureActivity.this, getString(R.string.appelezServeur), Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Toast.makeText(FactureActivity.this, getString(R.string.payementValide), Toast.LENGTH_SHORT).show();
                    prixFacture.setText("" + String.format("%.2f",Facture.factureActuelle.computePrice()) + " €");

                    Facture.factureActuelle.facDet.get(position / 2).ajouterCommandeToFacture(1);

            }else{
                if(Bartender.connectedUser != null)
                    Facture.factureActuelle.validateLivraison(Facture.factureActuelle.facDet.get((position / 2)).getNoProduit(), 1);
            }
            Intent intent = new Intent(FactureActivity.this, FactureActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            }
        });
    }

    private void load(List<String> exemple){
        for(int i = 0; i < Facture.factureActuelle.facDet.size(); i++)
        {
            Detail det = Facture.factureActuelle.facDet.get(i);
            Inventaire inv = Inventaire.getProduitFromNo(det.getNoProduit());
            Boisson boi = Boisson.getBoissonFromNo(inv.getNoBoisson());
            exemple.add(boi.getNom() + " " + inv.getFormat() + " cl");
            exemple.add(det.getaLivrer() + " | " + det.getDejaLivre() + "   ~   " + inv.getPrix() + " €");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.onCreate(null);
    }
}
