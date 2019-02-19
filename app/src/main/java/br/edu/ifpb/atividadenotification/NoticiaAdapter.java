package br.edu.ifpb.atividadenotification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoticiaAdapter extends ArrayAdapter<Noticia> {

    private final Context context;
    private final ArrayList<Noticia> noticias;

    public NoticiaAdapter(Context context, ArrayList<Noticia> noticias){
        super(context, R.layout.noticia, noticias);
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.noticia, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.noticia_title);
        TextView summary = (TextView) rowView.findViewById(R.id.noticia_summary);
        TextView content = (TextView) rowView.findViewById(R.id.noticia_content);

        Noticia noticia = noticias.get(position);

        title.setText(noticia.getTitle());
        summary.setText(noticia.getSummary());
        content.setText(noticia.getContent());

        return rowView;
    }
}