package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20172.osapp.R;
import br.edu.iff.pooa20172.osapp.model.Evento;
import io.realm.Realm;

public class AdicionaEventoActivity extends AppCompatActivity {

    EditText descricao, autorRegistro, dataRegistro;
    Button btsalvar,btalterar, btdeletar;

    int id;
    Evento evento;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_evento);

        descricao = (EditText) findViewById(R.id.ed_descricao);
        autorRegistro = (EditText) findViewById(R.id.ed_setor);
        dataRegistro = (EditText) findViewById(R.id.ed_dataRegistro);
        btsalvar = (Button) findViewById(R.id.bt_salvar_evento);
        btalterar = (Button) findViewById(R.id.bt_alterar_evento);
        btdeletar = (Button) findViewById(R.id.bt_deletar_evento);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            evento = realm.where(Evento.class).equalTo("id",id).findFirst();

            descricao.setText(evento.getDescricao());
            autorRegistro.setText(evento.getAutorCadastro());
            autorRegistro.setText(evento.getDataRegistro());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        evento.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Evento.class).max("id") !=null)
            proximoID = realm.where(Evento.class).max("id").intValue()+1;

        realm.beginTransaction();
        Evento evento = new Evento();
        evento.setId(proximoID);
        evento.setDescricao(descricao.getText().toString());
        evento.setAutorCadastro(autorRegistro.getText().toString());
        evento.setDataRegistro(dataRegistro.getText().toString());

        realm.copyToRealm(evento);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        evento.setDescricao(descricao.getText().toString());
        evento.setAutorCadastro(autorRegistro.getText().toString());
        evento.setDataRegistro(dataRegistro.getText().toString());

        realm.copyToRealm(evento);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Evento Alterado", Toast.LENGTH_LONG).show();
        this.finish();

    }

}
