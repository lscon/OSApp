package br.edu.iff.pooa20172.osapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.iff.pooa20172.osapp.R;

public class ActivityAbertura extends AppCompatActivity {

    private static int ABERTURA_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(ActivityAbertura.this, ActivityPrincipal.class);
                startActivity(i);

                finish();
            }
        }, ABERTURA_TIME_OUT);
    }
}
