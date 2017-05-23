package helppet.com.br.helppetmobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import helppet.com.br.helppetmobile.DAO.DenunciaDAO;
import helppet.com.br.helppetmobile.DenunciasActivity;
import helppet.com.br.helppetmobile.EventosActivity;
import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.modelo.Denuncia;

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

        Button botaoOng = (Button) findViewById(R.id.botaoOng);
        context = this;
        botaoOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,OngsActivity.class);
                startActivity(i);
            }
        });

        Button botaoClinica = (Button) findViewById(R.id.botaoClinica);
        context = this;
        botaoClinica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ClinicaActivity.class);
                startActivity(i);
            }
        });

        criarDenunciaActivity = new CriarDenunciaActivity();


        if(isNetworkAvailable() && criarDenunciaActivity.temDenuncia(this)){
            criarDenunciaActivity.persistirDenunciasLocias(this);
        }

    }
    CriarDenunciaActivity criarDenunciaActivity;


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private Context context;

}
