package helppet.com.br.helppetmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.modelo.Anuncio;

/**
 * Created by aluno on 18/05/17.
 */

public class AnuncioAdapter extends BaseAdapter {
    public AnuncioAdapter(Context context, ArrayList<Anuncio> lista) {
        this.context = context;
        this.listaAnuncios = lista;
    }

    private Context context;
    private ArrayList<Anuncio> listaAnuncios;

    @Override
    public int getCount() {
        return listaAnuncios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAnuncios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Anuncio anuncio = listaAnuncios.get(position);

        View viewRetorno = LayoutInflater.from(context).inflate(R.layout.activity_anuncios, parent, false);
        TextView tituloAnuncio = (TextView) viewRetorno.findViewById(R.id.tituloAnuncio);
        TextView tipoAnuncio = (TextView) viewRetorno.findViewById(R.id.tipoAnuncio);

        tituloAnuncio.setText(anuncio.getTitulo());
        tipoAnuncio.setText(anuncio.getTipo());

        return viewRetorno;
    }
}
