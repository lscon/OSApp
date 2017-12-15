package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.adapter.ChamadoAdapter;
import br.edu.iff.pooa20172.osapp.model.Chamado;

public class ActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ListView lista = (ListView) findViewById(R.id.lvChamados);

        final ArrayList<Chamado> chamados = adicionaChamados();

        ArrayAdapter adapter = new ChamadoAdapter(this, chamados);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivityDetalhe.class);
                intent.putExtra("descricao", chamados.get(i).getDescricao());
                intent.putExtra("setor", chamados.get(i).getSetor());
                intent.putExtra("usuario", chamados.get(i).getUsuario());
                startActivity(intent);
            }
        });
    }

    private ArrayList<Chamado> adicionaChamados() {

        ArrayList<Chamado> chamados = new ArrayList<Chamado>();

        Chamado c = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c);

        Chamado c1= new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c1);

        Chamado c2 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c2);

        Chamado c3 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c3);

        Chamado c4 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c4);

        Chamado c5 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c5);

        Chamado c6 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c6);

        Chamado c8 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c8);

        Chamado c7 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c7);

        Chamado c9 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c9);

        Chamado c10 = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c10);

        return chamados;
    }
}
