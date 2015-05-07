package lsinf1225.groupeq.bartender.activity.adapter;

import android.graphics.Color;
import android.widget.ArrayAdapter;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Boisson;
import lsinf1225.groupeq.bartender.models.Inventaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

        ImageView icon = (ImageView) rowView.findViewById(R.id.inventaireIcon);

        switch(b.getType()){
            case "biere": icon.setImageResource(R.drawable.biere);
                break;
            case "soft": icon.setImageResource(R.drawable.soft);
                break;
            case "eau": icon.setImageResource(R.drawable.soft);
                break;
            case "vin": icon.setImageResource(R.drawable.vin);
                break;
            case "spirit": icon.setImageResource(R.drawable.spirit);
                break;
            default: icon.setImageResource(R.mipmap.ic_launcher);
                break;
        }

        name.setText(b.getNom() + " " + i.getFormat());
        seuil.setText(getContext().getString(R.string.seuil) + ": " + Integer.toString((int) i.getQteSeuil()));
        stock.setText(getContext().getString(R.string.stock) + ": " + Integer.toString((int)i.getQteStock()));

        if(i.getQteStock() < i.getQteSeuil())
            rowView.setBackgroundColor(Color.parseColor("#FFB2AB"));// Rouge clair

        if(i.getQteStock() == 0)
            rowView.setBackgroundColor(Color.GRAY);

        if(i.getQteStock() == i.getQteMax())
            rowView.setBackgroundColor(Color.parseColor("#BBE2A3"));// Vert clair


        return rowView;
    }
}