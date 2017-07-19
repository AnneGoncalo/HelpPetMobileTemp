package helppet.com.br.helppetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesOngActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_ong);
        Bundle b = getIntent().getExtras();

        String nome = b.getString("nome");
        String email = b.getString("email");
        String local = b.getString("local");
        String telefone = b.getString("telefone");
        //String site = b.getString("site");
        String funcionamento = b.getString("funcionamento");
        String descricao = b.getString("descricao");

        nomeOng = (TextView) findViewById(R.id.nomeOngDescricao);
        emailOng = (TextView) findViewById(R.id.emailOngDescricao);
        localOng = (TextView) findViewById(R.id.localOngDescricao);
        telefoneOng = (TextView) findViewById(R.id.telefoneOngDescricao);
        //siteOng = (TextView) findViewById(R.id.siteOngDescricao);
        funciomentoOng = (TextView) findViewById(R.id.funcionamentoOngDescricao);
        descricaoOng = (TextView) findViewById(R.id.descricaoOngDescricao);

        nomeOng.setText(nome);
        emailOng.setText(email);
        telefoneOng.setText(telefone);
        localOng.setText(local);
        //siteOng.setText(site);
        funciomentoOng.setText(funcionamento);
        descricaoOng.setText(descricao);
    }

    private TextView nomeOng;
    private TextView emailOng;
    private TextView localOng;
    private TextView telefoneOng;
    //private TextView siteOng;
    private TextView funciomentoOng;
    private TextView descricaoOng;
}
