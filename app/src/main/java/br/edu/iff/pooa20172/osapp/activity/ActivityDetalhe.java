package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.adapter.ChamadoAdapter;
import br.edu.iff.pooa20172.osapp.adapter.EventoAdapter;
import br.edu.iff.pooa20172.osapp.model.Chamado;
import br.edu.iff.pooa20172.osapp.model.Evento;

public class ActivityDetalhe extends AppCompatActivity {

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

        ListView lista = (ListView) findViewById(R.id.lvEventos);

        final ArrayList<Evento> eventos = adicionaEventos();

        ArrayAdapter adapter = new EventoAdapter(this, eventos);

        lista.setAdapter(adapter);
    }

    private ArrayList<Evento> adicionaEventos() {

        ArrayList<Evento> eventos = new ArrayList<Evento>();

        Evento c = new Evento("Fonte substituida", "Rosevaldo",
                "10/10;2017");
        eventos.add(c);

        return eventos;
    }

}
