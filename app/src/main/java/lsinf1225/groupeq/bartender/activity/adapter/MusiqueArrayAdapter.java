package lsinf1225.groupeq.bartender.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import lsinf1225.groupeq.bartender.R;
import lsinf1225.groupeq.bartender.models.Musique;

/**
 * Created by Quentin on 4/05/15.
 */
public class MusiqueArrayAdapter extends ArrayAdapter<Musique> {
    private final Context context;
    private final Musique[] values;

    public MusiqueArrayAdapter(Context context, Musique[] values) {
        super(context, R.layout.musiquelayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.musiquelayout, parent, false);

        TextView name = (TextView) rowView.findViewById(R.id.musiqueName);
        TextView artist = (TextView) rowView.findViewById(R.id.musiqueArtist);
        TextView info = (TextView) rowView.findViewById(R.id.musiqueMoreInfo);

        Musique m = Musique.getMusiqueFromNo(values[position].getNoMusique());

        name.setText(m.getTitre());
        artist.setText(m.getArtiste());
        info.setText(getContext().getString(R.string.annee) + ": " + m.getAnnee() + ", " + getContext().getString(R.string.genre)+": "+ m.getGenre());

        return rowView;
    }
}
