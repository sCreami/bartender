package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Serveur;


public class OptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Button buttonOptionsConnexion = (Button) findViewById(R.id.buttonOptionsConnexion);
        Button buttonOptionslangue = (Button) findViewById(R.id.buttonOptionsLangue);
        Button buttonOptionsValider = (Button) findViewById(R.id.buttonOptionsValider);
        final EditText noTable = (EditText) findViewById(R.id.noTable);
        TextView optionsNom = (TextView) findViewById(R.id.optionsNom);

        // Boutton connexion
        if(!Serveur.isConnect())
            buttonOptionsConnexion.setText("Connexion");
        else
            buttonOptionsConnexion.setText("Déconnexion");

        // Connecté user
        if(Bartender.connectedUser == null) {
            // cache les options serveur
            optionsNom.setText("invité");
            noTable.setVisibility(View.GONE);
            buttonOptionsValider.setVisibility(View.GONE);
        } else {
            // affiche les options serveur
            optionsNom.setText(Bartender.connectedUser);
            noTable.setVisibility(View.VISIBLE);
            buttonOptionsValider.setVisibility(View.VISIBLE);
        }

        // Changer de table
        buttonOptionsValider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int table;

                try {
                    table = Integer.parseInt(noTable.getText().toString());
                }catch (Exception e){
                    Toast.makeText(OptionsActivity.this, "ParseInt errorgit ", Toast.LENGTH_SHORT).show();
                    table = 1;
                }

                if(table < 1) {
                    Toast.makeText(OptionsActivity.this, "Table incorrect", Toast.LENGTH_SHORT).show();
                    Bartender.table = 1;
                } else {
                    Toast.makeText(OptionsActivity.this, "Table set to "+table, Toast.LENGTH_SHORT).show();
                    Bartender.table = table;
                }
            }
        });

    }

    public void openConnexion(View view){
        if(!Serveur.isConnect()) {
            // Pour se connecter
            Intent intent = new Intent(OptionsActivity.this, ConnexionActivity.class);
            startActivity(intent);
        } else {
            // Pour se déconnecter
            Bartender.connectedUser = null;
            Intent intent = new Intent(OptionsActivity.this, OptionsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }
}
