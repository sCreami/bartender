package lsinf1225.groupeq.bartender.activity.adapter;

import android.widget.ArrayAdapter;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Inventaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alexis on 03/05/15.
 */
public class CarteArrayAdapter extends ArrayAdapter<Inventaire> {

    private final Context context;
    private final Inventaire[] values;

    public CarteArrayAdapter(Context context, Inventaire[] values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView firstLine = (TextView) rowView.findViewById(R.id.carteFirstLine);
        TextView secondLine = (TextView) rowView.findViewById(R.id.carteSecondLine);

        Boisson b = Boisson.getBoissonFromNo(values[position].getNoBoisson());

        firstLine.setText(b.getNom());

        secondLine.setText(b.getType());

        return rowView;
    }
}