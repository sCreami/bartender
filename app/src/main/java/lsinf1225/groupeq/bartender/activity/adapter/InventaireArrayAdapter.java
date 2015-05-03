package lsinf1225.groupeq.bartender.activity.adapter;

import android.widget.ArrayAdapter;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Inventaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alexis on 03/05/15.
 */
public class InventaireArrayAdapter extends ArrayAdapter<Inventaire> {

    private final Context context;
    private final Inventaire[] values;

    public InventaireArrayAdapter(Context context, Inventaire[] values) {
        super(context, R.layout.inventairelayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.inventairelayout, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.inventaireName);
        TextView seuil = (TextView) rowView.findViewById(R.id.inventaireSeuil);
        TextView stock = (TextView) rowView.findViewById(R.id.inventaireStock);

        Inventaire i = values[position];
        Boisson b = Boisson.getBoissonFromNo(values[position].getNoBoisson());


        //TODO Modifier adaptateur inventaire
        name.setText(b.getNom());
        seuil.setText(Double.toString(i.getQteSeuil()));
        stock.setText(Double.toString(i.getQteStock()));

        return rowView;
    }
}