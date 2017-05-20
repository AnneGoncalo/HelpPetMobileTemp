package helppet.com.br.helppetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesAnuncioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_anuncio);
        Bundle b = getIntent().getExtras();

        String titulo = b.getString("titulo");
        String tipo = b.getString("tipo");
        String descricao = b.getString("descricao");

        tituloAnuncioDescricao = (TextView) findViewById(R.id.tituloAnuncioDescricao);
        tipoAnuncioDescricao = (TextView) findViewById(R.id.tipoAnuncioDescricao);
        descricaoAnuncioDescricao = (TextView) findViewById(R.id.descricaoCompletaAnuncioDescricao);

        tituloAnuncioDescricao.setText(titulo);
        tipoAnuncioDescricao.setText(tipo);
        descricaoAnuncioDescricao.setText(descricao);
    }

    private TextView tituloAnuncioDescricao;
    private TextView tipoAnuncioDescricao;
    private TextView descricaoAnuncioDescricao;
}
