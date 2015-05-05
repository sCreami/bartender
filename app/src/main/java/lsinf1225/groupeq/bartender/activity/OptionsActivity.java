package lsinf1225.groupeq.bartender.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import lsinf1225.groupeq.bartender.Bartender;
import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Serveur;


public class OptionsActivity extends Activity {

    private static Button buttonOptionsConnexion;
    private static Button buttonOptionsLangue;
    private static Button buttonOptionsValider;
    private static EditText noTable;
    private static TextView optionsNom;
    private Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        buttonOptionsConnexion = (Button) findViewById(R.id.buttonOptionsConnexion);
        buttonOptionsLangue = (Button) findViewById(R.id.buttonOptionsLangue);
        buttonOptionsValider = (Button) findViewById(R.id.buttonOptionsValider);
        noTable = (EditText) findViewById(R.id.noTable);
        optionsNom = (TextView) findViewById(R.id.optionsNom);

        // Boutton connexion
        if(!Serveur.isConnect())
            buttonOptionsConnexion.setText(getResources().getString(R.string.connexion));
        else
            buttonOptionsConnexion.setText(getResources().getString(R.string.deconnexion));

        // Connecté user
        if(Bartender.connectedUser == null) {
            // cache les options serveur
            optionsNom.setText(getResources().getString(R.string.invite));
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

        buttonOptionsLangue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String[] items = {"Français","English"};

                AlertDialog.Builder builder = new AlertDialog.Builder(OptionsActivity.this);
                builder.setTitle("Select language");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if(items[item].equals("Français"))
                            changeLang("fr");
                        else
                            changeLang("en");
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
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

    public void changeLang(String lang)
    {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }


    public void saveLocale(String lang)
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }

}
