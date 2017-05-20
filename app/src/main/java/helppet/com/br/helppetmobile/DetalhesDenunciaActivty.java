package helppet.com.br.helppetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetalhesDenunciaActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_denuncia);
        Bundle b = getIntent().getExtras();

        String titulo = b.getString("titulo");
        String tipo = b.getString("tipo");
        String local = b.getString("local");
        String descricao = b.getString("descricao");

        tituloDenunciaDescricao = (TextView) findViewById(R.id.tituloDenunciaDescricao);
        tipoDenunciaDescricao = (TextView) findViewById(R.id.tipoDenunciaDescricao);
        localDenunciaDescricao = (TextView) findViewById(R.id.localDenunciaDescricao);
        descricaoDenunciaDescricao = (TextView) findViewById(R.id.descricaoCompletaDenunciaDescricao);

        tituloDenunciaDescricao.setText(titulo);
        localDenunciaDescricao.setText(tipo);
        tipoDenunciaDescricao.setText(local);
        descricaoDenunciaDescricao.setText(descricao);
    }

    private TextView tituloDenunciaDescricao;
    private TextView localDenunciaDescricao;
    private TextView tipoDenunciaDescricao;
    private TextView descricaoDenunciaDescricao;
}
