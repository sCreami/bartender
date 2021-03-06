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
import lsinf1225.groupeq.bartender.activity.adapter.MusiqueArrayAdapter;
import lsinf1225.groupeq.bartender.models.Facture;
import lsinf1225.groupeq.bartender.models.Inventaire;
import lsinf1225.groupeq.bartender.models.Musique;


public class MusiqueActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Musique> musiques = Musique.getMusiques();

        Musique[] musique = new Musique[musiques.size()];
        musique = musiques.toArray(musique);

        MusiqueArrayAdapter adapter = new MusiqueArrayAdapter(this, musique);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(Bartender.connectedUser != null) {
            Musique m = Musique.getMusiqueFromNo(position + 1);
            Toast.makeText(MusiqueActivity.this,getString(R.string.title_activity_musique)+ " " + m.getTitre() + " " + getString(R.string.ajoutPlaylist), Toast.LENGTH_SHORT).show();
        }
        else if (Facture.factureActuelle.getJetons()>0) {
            Facture.factureActuelle.setJetons(Facture.factureActuelle.getJetons() - 1);
            Musique m = Musique.getMusiqueFromNo(position + 1);
            Toast.makeText(MusiqueActivity.this,getString(R.string.title_activity_musique)+ " " + m.getTitre() + " " + getString(R.string.ajoutPlaylist), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MusiqueActivity.this, getString(R.string.noJetons), Toast.LENGTH_SHORT).show();
        }
    }
}
