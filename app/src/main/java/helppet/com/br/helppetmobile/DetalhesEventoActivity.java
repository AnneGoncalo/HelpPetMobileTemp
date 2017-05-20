package helppet.com.br.helppetmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import helppet.com.br.helppetmobile.R;

public class DetalhesEventoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_evento);
        Bundle b = getIntent().getExtras();

        String nome = b.getString("nomeEvento");
        String data = b.getString("dataEvento");
        String horario = b.getString("horarioEvento");
        String local = b.getString("localEvento");
        String descricao = b.getString("descricaoEvento");

        nomeEventoDescricao = (TextView) findViewById(R.id.nomeEventoDescricao);
        dataEventoDescricao = (TextView) findViewById(R.id.dataEventoDescricao);
        horarioEventoDescricao = (TextView) findViewById(R.id.horarioEventoDescricao);
        localEventoDescricao = (TextView) findViewById(R.id.localEventoDescricao);
        descricaoEventoDescricao = (TextView) findViewById(R.id.descricaoEventoDescricao);


        nomeEventoDescricao.setText(nome);
        dataEventoDescricao.setText(data);
        horarioEventoDescricao.setText(horario);
        localEventoDescricao.setText(local);
        descricaoEventoDescricao.setText(descricao);
    }

    private TextView nomeEventoDescricao;
    private TextView dataEventoDescricao;
    private TextView horarioEventoDescricao;
    private TextView localEventoDescricao;
    private TextView descricaoEventoDescricao;
}
