package helppet.com.br.helppetmobile;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import helppet.com.br.helppetmobile.modelo.Denuncia;
import helppet.com.br.helppetmobile.util.Path;

public class CriarDenunciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_denuncia);
        entradaTitulo = (EditText) findViewById(R.id.entradaTituloDenuncia);
        entradaTipo = (EditText) findViewById(R.id.entradaTipoDenuncia);
        entradaLocal = (EditText) findViewById(R.id.entradaLocalDenuncia);
        entradaDescricao = (EditText) findViewById(R.id.entradaDescricaoDenuncia);
    }

    private Denuncia denuncia;
    private EditText entradaTitulo;
    private EditText entradaTipo;
    private EditText entradaLocal;
    private EditText entradaDescricao;


    public void cadastrarDenuncia(View view) {
        String tipo = entradaTipo.getText().toString();
        String titulo = entradaTitulo.getText().toString();
        String descricao = entradaDescricao.getText().toString();
        String local = entradaLocal.getText().toString();


        denuncia = new Denuncia(titulo, descricao, tipo, local);
        Gson gson = new Gson();

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(" Deseja enviar esta denúncia ? ");
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Gson gson = new Gson();
                String jsonDenuncia = gson.toJson(denuncia);
                new CriarDenuncia().execute(Path.getDenunciaPath(), jsonDenuncia);
                finish();
            }
        });
        dialog.setNeutralButton("Não",null);
        dialog.show();




    }

    public class CriarDenuncia extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {

                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

                PrintStream printStream = new PrintStream(connection.getOutputStream());


                printStream.print(params[1]);

                connection.connect();
                String jsonDeResposta = new Scanner(connection.getInputStream()).next();

                return jsonDeResposta;

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
        protected void onPostExecute(String resultadoJason) {
            super.onPostExecute(resultadoJason);


        }


    }

}
