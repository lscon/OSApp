package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.adapter.ChamadoAdapter;
import br.edu.iff.pooa20172.osapp.adapter.ClickRecyclerViewListener;
import br.edu.iff.pooa20172.osapp.adapter.EventoAdapter;
import br.edu.iff.pooa20172.osapp.model.Chamado;
import br.edu.iff.pooa20172.osapp.model.Evento;
import io.realm.Realm;

public class ActivityDetalhe extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent intent = getIntent();

        String descricao = (String) intent.getSerializableExtra("descricao");
        String setor = (String) intent.getSerializableExtra("setor");
        String usuario = (String) intent.getSerializableExtra("usuario");

        TextView tvDescricao = (TextView) findViewById(R.id.tvDescricao);
        TextView tvSetor = (TextView) findViewById(R.id.tvSetor);
        TextView tvUsuario = (TextView) findViewById(R.id.tvUsuario);

        tvDescricao.setText(descricao);
        tvSetor.setText(setor);
        tvUsuario.setText(usuario);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityDetalhe.this,AdiconaEventoActivity.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }

    private List<Evento> getEventos(){

        return (List)realm.where(Evento.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Evento evento = (Evento) object;
        Intent intent = new Intent(ActivityDetalhe.this,AdicionaEventoActivity.class);
        intent.putExtra("id",evento.getId());
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Eventos);

        recyclerView.setAdapter(new EventoAdapter(getEventos(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();
    }

}