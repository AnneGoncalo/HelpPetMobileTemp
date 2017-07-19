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

import helppet.com.br.helppetmobile.adapter.EventoAdapter;
import helppet.com.br.helppetmobile.modelo.Evento;
import helppet.com.br.helppetmobile.util.Path;


public class EventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_evento);
        context = this;
        listViewEventos = (ListView) findViewById(R.id.listaEventos);
        if(isNetworkAvailable()){
            new ConsultaEventos().execute(Path.getEventoPath());
        }else {
            Toast.makeText(context,"Sem conexão com a interntet",Toast.LENGTH_SHORT).show();
        }

    }

    private Context context;
    private ListView listViewEventos;
    private EventoAdapter eventoAdapter;

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public class ConsultaEventos extends AsyncTask<String, String, String> {

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
            TypeToken<List<Evento>> tipoDado = new TypeToken<List<Evento>>() {
            };

            final ArrayList<Evento> eventos = gson.fromJson(resposta, tipoDado.getType());

            if(eventos.size() > 0 ){
                eventoAdapter = new EventoAdapter(context,eventos);
                listViewEventos.setAdapter(eventoAdapter);
                listViewEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i  = new Intent(context, DetalhesDenunciaActivty.class);
                        Evento eventoSelecionado = eventos.get(position);

                        i.putExtra("nomeEvento",eventoSelecionado.getNome());
                        i.putExtra("dataEvento",eventoSelecionado.getData());
                        i.putExtra("horarioEvento",eventoSelecionado.getHorario());
                        i.putExtra("localEvento",eventoSelecionado.getLocalizacao());
                        i.putExtra("descricaoEvento",eventoSelecionado.getDescricao());

                        startActivity(i);
                    }
                });
            }

        }

    }

}
