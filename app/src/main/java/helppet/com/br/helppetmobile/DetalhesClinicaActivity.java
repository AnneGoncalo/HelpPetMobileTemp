package helppet.com.br.helppetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalhesClinicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_clinica);
        Bundle b = getIntent().getExtras();

        String nome = b.getString("nome");
        String email = b.getString("email");
        String local = b.getString("local");
        String telefone = b.getString("telefone");
        String site = b.getString("site");
        String funcionamento = b.getString("funcionamento");
        String descricao = b.getString("descricao");

        nomeClinica = (TextView) findViewById(R.id.nomeClinicaDescricao);
        emailClinica = (TextView) findViewById(R.id.emailClinicaDescricao);
        localClinica = (TextView) findViewById(R.id.localClinicaDescricao);
        telefoneClinica = (TextView) findViewById(R.id.telefoneClinicaDescricao);
        siteClinica = (TextView) findViewById(R.id.siteClinicaDescricao);
        funciomentoClinica = (TextView) findViewById(R.id.funcionamentoClinicaDescricao);
        descricaoClinica = (TextView) findViewById(R.id.descricaoClinicaDescricao);

        nomeClinica.setText(nome);
        emailClinica.setText(email);
        telefoneClinica.setText(telefone);
        localClinica.setText(local);
        siteClinica.setText(site);
        funciomentoClinica.setText(funcionamento);
        descricaoClinica.setText(descricao);
    }

    private TextView nomeClinica;
    private TextView emailClinica;
    private TextView localClinica;
    private TextView telefoneClinica;
    private TextView siteClinica;
    private TextView funciomentoClinica;
    private TextView descricaoClinica;

}
