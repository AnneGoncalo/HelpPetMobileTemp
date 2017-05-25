package helppet.com.br.helppetmobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

import helppet.com.br.helppetmobile.DAO.DenunciaDAO;
import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.adapter.DenunciaAdapter;
import helppet.com.br.helppetmobile.modelo.Denuncia;
import helppet.com.br.helppetmobile.util.Path;

public class DenunciasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_denuncia);
        context = this;
        listViewDeuncias = (ListView) findViewById(R.id.listaDenuncia);
        denunciaDAO = new DenunciaDAO(this);
    }

    private DenunciaDAO denunciaDAO ;

    @Override
    public void onStart() {
        super.onStart();
        if (isNetworkAvailable()) {
            new ConsultaDenuncias().execute(Path.getDenunciaPath());
        } else {
<<<<<<< HEAD
            Toast.makeText(this, "Sem conexão com a internet", Toast.LENGTH_LONG).show();
=======
            Toast.makeText(this, " Sem conexão com a internet ", Toast.LENGTH_LONG).show();
             final ArrayList<Denuncia> listaDenuncias = denunciaDAO.buscarDenuncia();
            if (listaDenuncias.size() > 0) {
                denunciaAdapter = new DenunciaAdapter(context, listaDenuncias);
                listViewDeuncias.setAdapter(denunciaAdapter);
                listViewDeuncias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i = new Intent(context, DetalhesDenunciaActivty.class);
                        Denuncia denunciaSelecionada = listaDenuncias.get(position);

                        i.putExtra("titulo", denunciaSelecionada.getTituloDenuncia());
                        i.putExtra("tipo", denunciaSelecionada.getTipoDenuncia());
                        i.putExtra("local", denunciaSelecionada.getLocalizacao());
                        i.putExtra("descricao", denunciaSelecionada.getDescricaoDenuncia());

                        startActivity(i);
                    }
                });
            }



>>>>>>> b373dcd401e35bca0295766e80712c7f1c9bac61
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private Context context;
    private ListView listViewDeuncias;
    private DenunciaAdapter denunciaAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.denuncia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menu_selecionado = item.getItemId();
        if (menu_selecionado == R.id.menuDenuncia) {
            Intent i = new Intent(this, CriarDenunciaActivity.class);
            startActivity(i);
        }
        return true;
    }

<<<<<<< HEAD
=======



>>>>>>> b373dcd401e35bca0295766e80712c7f1c9bac61
    public class ConsultaDenuncias extends AsyncTask<String, String, String> {

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
            TypeToken<List<Denuncia>> tipoDado = new TypeToken<List<Denuncia>>() {
            };

            final ArrayList<Denuncia> denuncias = gson.fromJson(resposta, tipoDado.getType());

            if (denuncias.size() > 0) {
                denunciaAdapter = new DenunciaAdapter(context, denuncias);
                listViewDeuncias.setAdapter(denunciaAdapter);
                listViewDeuncias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent i = new Intent(context, DetalhesDenunciaActivty.class);
                        Denuncia denunciaSelecionada = denuncias.get(position);

                        i.putExtra("titulo", denunciaSelecionada.getTituloDenuncia());
                        i.putExtra("tipo", denunciaSelecionada.getTipoDenuncia());
                        i.putExtra("local", denunciaSelecionada.getLocalizacao());
                        i.putExtra("descricao", denunciaSelecionada.getDescricaoDenuncia());

                        startActivity(i);
                    }
                });
            }

        }

    }
}


