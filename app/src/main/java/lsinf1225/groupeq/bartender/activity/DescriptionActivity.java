package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.EventLogTags;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;

public class DescriptionActivity extends Activity {

    static Button ajouter;
    static Button livrer;
    static TextView nom;
    static TextView description;
    static TextView prix;
    static TextView format;
    static TextView taux;
    static TextView type;

    int lastId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        ajouter = (Button)findViewById(R.id.buttonAjouterProduit);
        ajouter.setOnClickListener(ajouterListener);

        livrer = (Button)findViewById(R.id.buttonLivrerProduit);
        livrer.setOnClickListener(livrerListener);
        if(Bartender.connectedUser == null)
            livrer.setVisibility(View.GONE);
        else
            livrer.setVisibility(View.VISIBLE);

        Intent myIntent = getIntent();
        String position = myIntent.getStringExtra("position");
        int pos = Integer.parseInt(position); // p-1

        Inventaire in = Inventaire.getProduitFromNo(pos + 1);
        lastId = in.getNoProduit();
        Boisson bo = Boisson.getBoissonFromNo(in.getNoBoisson());

        ImageView pic = (ImageView) findViewById(R.id.descriptionPicture);


        int defaultImg = R.mipmap.ic_launcher;
        switch(bo.getType()){
            case "biere": defaultImg = R.drawable.biere;
                break;
            case "soft": defaultImg = R.drawable.soft;
                break;
            case "eau": defaultImg = R.drawable.soft;
                break;
            case "vin": defaultImg = R.drawable.vin;
                break;
            case "spirit": defaultImg = R.drawable.spirit;
                break;
            default: defaultImg = R.mipmap.ic_launcher;
                break;
        }

        int id = (!bo.getPhoto().equals("")) ? getResources().getIdentifier(bo.getPhoto(), "drawable", getPackageName()) : defaultImg;
        pic.setImageResource(id);


        nom = (TextView) findViewById(R.id.produitNom);
        description = (TextView) findViewById(R.id.produitDescription);
        prix = (TextView) findViewById(R.id.produitPrix);
        format = (TextView) findViewById(R.id.produitFormat);
        taux = (TextView) findViewById(R.id.produitTaux);
        type = (TextView) findViewById(R.id.produitType);

        nom.setText(bo.getNom());
        if(Bartender.locale.equals("fr"))
            description.setText(bo.getDescriptionFR());
        else
            description.setText(bo.getDescriptionEN());

        prix.setText(in.getPrix()+"€");
        format.setText(in.getFormat()+"cl");
        taux.setText(Double.toString(bo.getTauxAlcool())+"%");
        type.setText(bo.getType());

        if(in.getQteStock() == 0) {
            ajouter.setClickable(false);
            ajouter.setBackgroundColor(Color.GRAY);
        }
    }

    private View.OnClickListener ajouterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int r = Facture.factureActuelle.addDetail(lastId, 1);
            if (Inventaire.getProduitFromNo(lastId).getQteStock() == 0) {
                Toast.makeText(DescriptionActivity.this, getString(R.string.stockVide), Toast.LENGTH_SHORT).show();
                ajouter.setClickable(false);
                ajouter.setBackgroundColor(Color.GRAY);
            }
            else
                Toast.makeText(DescriptionActivity.this, getString(R.string.boissonAjoutee) + " x1", Toast.LENGTH_SHORT).show();

        }
    };

    private View.OnClickListener livrerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Facture.factureActuelle.validateLivraison(lastId, 1);
            Toast.makeText(DescriptionActivity.this, getString(R.string.boissonLivree) + " x1", Toast.LENGTH_SHORT).show();
        }
    };
}
