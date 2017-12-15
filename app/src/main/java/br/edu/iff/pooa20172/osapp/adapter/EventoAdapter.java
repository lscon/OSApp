package br.edu.iff.pooa20172.osapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.model.Chamado;
import br.edu.iff.pooa20172.osapp.model.Evento;

/**
 * Created by fazenda on 15/12/17.
 */

public class EventoAdapter extends ArrayAdapter<Evento> {

    private final Context context;
    private final ArrayList<Evento> elementos;

    public EventoAdapter(Context context, ArrayList<Evento> elementos) {
        super(context, R.layout.item_evento, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_evento, parent, false);

        TextView descricao = (TextView) rowView.findViewById(R.id.tvDescricao);
        TextView autorCadastro = (TextView) rowView.findViewById(R.id.tvAutorCadastro);
        TextView dataRegistro = (TextView) rowView.findViewById(R.id.tvDataRegistro);

        descricao.setText(elementos.get(position).getDescricao());
        autorCadastro.setText(elementos.get(position).getAutorCadastro());
        dataRegistro.setText(elementos.get(position).getDataRegistro());
        return rowView;
    }

}
