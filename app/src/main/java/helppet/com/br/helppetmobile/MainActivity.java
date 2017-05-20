package helppet.com.br.helppetmobile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import helppet.com.br.helppetmobile.DenunciasActivity;
import helppet.com.br.helppetmobile.EventosActivity;
import helppet.com.br.helppetmobile.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoDenuncia = (Button) findViewById(R.id.botaoDenuncia);
        context = this;
        botaoDenuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DenunciasActivity.class);
                startActivity(i);
            }
        });

        Button botaoEvento = (Button) findViewById(R.id.botaoEvento);
        context = this;
        botaoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,EventosActivity.class);
                startActivity(i);
            }
        });

        Button botaoExperiencia = (Button) findViewById(R.id.botaoExperiencia);
        context = this;
        botaoExperiencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ExperienciaActivity.class);
                startActivity(i);
            }
        });

        Button botaoAnuncio = (Button) findViewById(R.id.botaoAnuncios);
        context = this;
        botaoAnuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,AnunciosActivity.class);
                startActivity(i);
            }
        });
    }

    private Context context;

}
