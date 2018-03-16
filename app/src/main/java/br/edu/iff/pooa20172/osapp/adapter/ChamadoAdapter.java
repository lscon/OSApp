package br.edu.iff.pooa20172.osapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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

/**
 * Created by fazenda on 14/12/17.
 */

public class ChamadoAdapter extends RecyclerView.Adapter {

    private List<Chamado> chamados;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public ChamadoAdapter(List<Chamado> chamados, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {

        this.chamados = chamados;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_chamado, parent, false);
        ChamadoAdapter.ChamadoViewHolder chamadoViewHolder = new ChamadoAdapter.ChamadoViewHolder(view);
        return chamadoViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,
                                 int position) {

        ChamadoAdapter.ChamadoViewHolder holder = (ChamadoAdapter.ChamadoViewHolder) viewHolder;

        Chamado chamado = chamados.get(position) ;

        holder.descricao.setText(Chamado.getDescricao());
        holder.setor.setText(Chamado.getSetor());
        holder.usuario.setText(Chamado.getUsuario());



    }

    @Override
    public int getItemCount() {

        return chamados.size();
    }

    private void updateItem(int position) {

    }

    // Método responsável por remover um usuário da lista.
    private void removerItem(int position) {

    }

    public class ChamadoViewHolder extends RecyclerView.ViewHolder {

        private final TextView descricao;
        private final TextView setor;
        private final TextView usuario;


        public ChamadoViewHolder(View itemView) {
            super(itemView);
            descricao = (TextView) itemView.findViewById(R.id.tvDescricao);
            setor = (TextView) itemView.findViewById(R.id.tvSetor);
            usuario = (TextView) itemView.findViewById(R.id.tvUsuario);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(chamados.get(getLayoutPosition()));
                }
            });
        }
    }
}