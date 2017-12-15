package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.iff.pooa20172.osapp.R;

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
    }
}
