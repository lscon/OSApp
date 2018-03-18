package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.adapter.ChamadoAdapter;
import br.edu.iff.pooa20172.osapp.adapter.ClickRecyclerViewListener;
import br.edu.iff.pooa20172.osapp.model.Chamado;
import io.realm.Realm;

public class ActivityPrincipal extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btAddChamado = (Button) findViewById(R.id.btChamado);

        realm = Realm.getDefaultInstance();

        btAddChamado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityPrincipal.this, ActivityDetalhe.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }

    private List<Chamado> getChamados(){

        return (List)realm.where(Chamado.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Chamado chamado = (Chamado) object;
        Intent intent = new Intent(ActivityPrincipal.this,ActivityDetalhe.class);
        intent.putExtra("id",chamado.getId());
        startActivity(intent);

    }

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_Chamados);

        recyclerView.setAdapter(new ChamadoAdapter(getChamados(),this,this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);


    }

    @Override
    public void finish(){
        realm.close();
    }

}