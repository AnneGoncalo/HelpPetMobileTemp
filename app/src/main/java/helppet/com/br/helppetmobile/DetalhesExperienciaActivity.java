package helppet.com.br.helppetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesExperienciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_experiencia);
        Bundle b = getIntent().getExtras();

        String titulo = b.getString("titulo");
        String tipo = b.getString("tipo");
        String data = b.getString("data");
        String texto = b.getString("texto");

        tituloExperienciaDescricao = (TextView) findViewById(R.id.tituloExperienciaDescricao);
        tipoExperienciaDescrcao = (TextView) findViewById(R.id.tipoExperienciaDescricao);
        dataExperienciaDescricao = (TextView) findViewById(R.id.dataExperienciaDescricao);
        textoExperienciaDescricao = (TextView) findViewById(R.id.descricaoCompletaExperienciaDescricao);

        tituloExperienciaDescricao.setText(titulo);
        tipoExperienciaDescrcao.setText(tipo);
        dataExperienciaDescricao.setText(data);
        textoExperienciaDescricao.setText(texto);
    }

    private TextView tituloExperienciaDescricao;
    private TextView tipoExperienciaDescrcao;
    private TextView dataExperienciaDescricao;
    private TextView textoExperienciaDescricao;
}
