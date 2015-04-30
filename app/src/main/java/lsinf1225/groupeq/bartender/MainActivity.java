package lsinf1225.groupeq.bartender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void openCarte(View view)
    {
        Intent intent = new Intent(MainActivity.this, CarteActivity.class);
        startActivity(intent);
    }

    public void openFacture(View view)
    {
        Intent intent = new Intent(MainActivity.this, FactureActivity.class);
        startActivity(intent);
    }

    public void openMusique(View view)
    {
        Intent intent = new Intent(MainActivity.this, MusiqueActivity.class);
        startActivity(intent);
    }

    public void openInventaire(View view)
    {
        Intent intent = new Intent(MainActivity.this, InventaireActivity.class);
        startActivity(intent);
    }

    public void openOptions(View view)
    {
        Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
        startActivity(intent);
    }
}
