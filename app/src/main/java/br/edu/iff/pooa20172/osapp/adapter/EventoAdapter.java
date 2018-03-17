package br.edu.iff.pooa20172.osapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.model.Chamado;
import br.edu.iff.pooa20172.osapp.model.Evento;

/**
 * Created by fazenda on 15/12/17.
 */

public class EventoAdapter extends RecyclerView.Adapter {

    private final List<Evento> eventos;
    private final Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public EventoAdapter(List<Evento> eventos, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.eventos = eventos;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_evento, parent, false);
        EventoViewHolder eventoViewHolder = new EventoViewHolder(view);
        return eventoViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        EventoViewHolder holder = (EventoViewHolder) viewHolder;

        Evento evento = eventos.get(position) ;

        holder.descricao.setText(evento.getDescricao());
        holder.autorCadastro.setText(evento.getAutorCadastro());
        holder.dataRegistro.setText(evento.getDataRegistro());

    }

    @Override
    public int getItemCount() {

        return eventos.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class EventoViewHolder extends RecyclerView.ViewHolder {

        private final TextView descricao;
        private final TextView autorCadastro;
        private final TextView dataRegistro;


        public EventoViewHolder(View itemView) {
            super(itemView);
            descricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            autorCadastro = (TextView) itemView.findViewById(R.id.tvAutorCadastro);
            dataRegistro = (TextView) itemView.findViewById(R.id.tvDataRegistro);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(eventos.get(getLayoutPosition()));
                }
            });
        }
    }
}