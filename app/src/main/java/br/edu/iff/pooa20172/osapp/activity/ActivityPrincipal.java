package br.edu.iff.pooa20172.osapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.model.Chamado;

public class ActivityPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    private ArrayList<Chamado> adicionaChamado() {

        ArrayList<Chamado> chamados = new ArrayList<Chamado>();

        Chamado c = new Chamado("PC não liga", "Hardware",
                "Tesouraria", "Pedro", "11/12/2017");
        chamados.add(c);
    }
}
