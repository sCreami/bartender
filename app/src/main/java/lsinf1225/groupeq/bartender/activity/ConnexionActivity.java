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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        if(!getResources().getConfiguration().locale.toString().equals(Bartender.locale)) {
            setLocale(Bartender.locale);
            refreshActivity();
        }

        final EditText connexionLogin = (EditText) findViewById(R.id.connexionLogin);
        final EditText connexionMDP = (EditText) findViewById(R.id.connexionMDP);
        Button buttonConnexion = (Button) findViewById(R.id.buttonConnexion);

        buttonConnexion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(Serveur.seConnecter(connexionLogin.getText().toString(), connexionMDP.getText().toString()) != 1) {
                    Toast.makeText(ConnexionActivity.this, "Login incorrect", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(ConnexionActivity.this, OptionsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        refreshActivity();
    }

    public void refreshActivity() {
        Intent intent = new Intent(this, ConnexionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
