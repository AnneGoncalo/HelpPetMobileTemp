package helppet.com.br.helppetmobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import helppet.com.br.helppetmobile.adapter.ClinicaAdapter;
import helppet.com.br.helppetmobile.adapter.DenunciaAdapter;
import helppet.com.br.helppetmobile.modelo.Denuncia;
import helppet.com.br.helppetmobile.modelo.PessoaJuridica;
import helppet.com.br.helppetmobile.util.Path;

public class ClinicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_clinica);
        context = this;
        listViewClinicas = (ListView) findViewById(R.id.listaClinica);
        if(isNetworkAvailable()){
            new ConsultaClinicas().execute(Path.getClinicaPath());
        }else{
            Toast.makeText(context,"Sem conexão com a interntet",Toast.LENGTH_SHORT).show();
        }

    }

    private Context context;
    private ListView listViewClinicas;
    private ClinicaAdapter clinicaAdapter;

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public class ConsultaClinicas extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {

                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(String resposta) {
            super.onPostExecute(resposta);
            Gson gson = new Gson();
            TypeToken<List<PessoaJuridica>> tipoDado = new TypeToken<List<PessoaJuridica>>() {
            };

            final ArrayList<PessoaJuridica> clinicas = gson.fromJson(resposta, tipoDado.getType());

            if(clinicas.size() > 0 ){
                clinicaAdapter = new ClinicaAdapter(context,clinicas);
                listViewClinicas.setAdapter(clinicaAdapter);
                listViewClinicas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i  = new Intent(context, DetalhesClinicaActivity.class);
                        PessoaJuridica clinicaSel = clinicas.get(position);

                        i.putExtra("nome",clinicaSel.getNomeUsuario());
                        i.putExtra("email",clinicaSel.getEmail());
                        i.putExtra("site",clinicaSel.getSite());
                        i.putExtra("local",clinicaSel.getLocalizacao());
                        i.putExtra("telefone",clinicaSel.getTelefone());
                        i.putExtra("funcionamento",clinicaSel.getFuncionamento());
                        i.putExtra("descricao",clinicaSel.getDescricao());

                        startActivity(i);
                    }
                });
            }

        }

    }
}
