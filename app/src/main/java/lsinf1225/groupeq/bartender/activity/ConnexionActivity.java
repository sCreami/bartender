package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Serveur;

public class ConnexionActivity extends Activity {

    static EditText connexionLogin;
    static EditText connexionMDP;
    static Button buttonConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        connexionLogin = (EditText) findViewById(R.id.connexionLogin);
        connexionMDP = (EditText) findViewById(R.id.connexionMDP);
        buttonConnexion = (Button) findViewById(R.id.buttonConnexion);

        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Serveur.seConnecter(connexionLogin.getText().toString(), connexionMDP.getText().toString()) != 1) {
                    Toast.makeText(ConnexionActivity.this, getString(R.string.badlogin), Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(ConnexionActivity.this, OptionsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
