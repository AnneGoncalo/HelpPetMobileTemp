package helppet.com.br.helppetmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.modelo.Anuncio;
import helppet.com.br.helppetmobile.modelo.PessoaJuridica;

/**
 * Created by anne on 22/05/17.
 */

public class OngAdapter extends BaseAdapter {
    public OngAdapter(Context context, ArrayList<PessoaJuridica> lista){
        this.context = context;
        this.lista = lista;
    }

    private Context context;
    private ArrayList<PessoaJuridica> lista;

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PessoaJuridica pj = lista.get(position);

        View viewRetorno = LayoutInflater.from(context).inflate(R.layout.activity_ongs, parent, false);
        TextView nome = (TextView) viewRetorno.findViewById(R.id.nomeOng);
        TextView local = (TextView) viewRetorno.findViewById(R.id.localOng);

        nome.setText(pj.getNome());
        local.setText(pj.getLocalizacao());

        return viewRetorno;
    }
}
