package br.edu.iff.pooa20172.osapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.model.Chamado;

/**
 * Created by fazenda on 14/12/17.
 */

public class ChamadoAdapter extends ArrayAdapter<Chamado> {

    private final Context context;
    private final ArrayList<Chamado> elementos;

    public ChamadoAdapter(Context context, ArrayList<Chamado> elementos) {
        super(context, R.layout.item_chamado, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_chamado, parent, false);

        TextView descricao = (TextView) rowView.findViewById(R.id.tvDescricao);
        TextView setor = (TextView) rowView.findViewById(R.id.tvSetor);
        TextView usuario = (TextView) rowView.findViewById(R.id.tvUsuario);

        descricao.setText(elementos.get(position).getDescricao());
        setor.setText(elementos.get(position).getSetor());
        usuario.setText(elementos.get(position).getUsuario());
        return rowView;
    }
}
