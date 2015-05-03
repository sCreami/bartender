package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Serveur;


public class OptionsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Button buttonOptionsConnexion = (Button) findViewById(R.id.buttonOptionsConnexion);

        if(!Serveur.isAdmin)
            buttonOptionsConnexion.setText("Connexion");
        else
            buttonOptionsConnexion.setText("Déconnexion");

    }

    public void openConnexion(View view){
        Intent intent = new Intent(OptionsActivity.this, ConnexionActivity.class);
        startActivity(intent);
    }
}
