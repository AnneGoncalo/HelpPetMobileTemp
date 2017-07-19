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

import helppet.com.br.helppetmobile.adapter.AnuncioAdapter;
import helppet.com.br.helppetmobile.adapter.OngAdapter;
import helppet.com.br.helppetmobile.modelo.Anuncio;
import helppet.com.br.helppetmobile.modelo.PessoaJuridica;
import helppet.com.br.helppetmobile.util.Path;

public class OngsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ong);
        context = this;
        listView = (ListView) findViewById(R.id.listaOng);
        if(isNetworkAvailable()){
            new ConsultaOngs().execute(Path.getOngPath());
        }else{
            Toast.makeText(context,"Sem conexão com a interntet",Toast.LENGTH_SHORT).show();
        }

    }

    private Context context;
    private ListView listView;
    private OngAdapter ongAdapter;

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public class ConsultaOngs extends AsyncTask<String, String, String> {

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
                if (connection != null)
                    connection.disconnect();
                try {
                    if (reader != null)
                        reader.close();
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

            final ArrayList<PessoaJuridica> ongs = gson.fromJson(resposta, tipoDado.getType());

            if(ongs.size() > 0 ){
                ongAdapter = new OngAdapter(context,ongs);
                listView.setAdapter(ongAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i  = new Intent(context, DetalhesOngActivity.class);
                        PessoaJuridica ongSelecionado = ongs.get(position);

                        i.putExtra("nome",ongSelecionado.getNome());
                        i.putExtra("email",ongSelecionado.getEmail());
                        i.putExtra("local",ongSelecionado.getLocalizacao());
                        i.putExtra("telefone",ongSelecionado.getTelefone());
                        //i.putExtra("site",ongSelecionado.getCpf_cnpj());
                        i.putExtra("funcionamento",ongSelecionado.getFuncionamento());
                        i.putExtra("descricao",ongSelecionado.getDescricao());

                        startActivity(i);
                    }
                });
            }

        }

    }
}
