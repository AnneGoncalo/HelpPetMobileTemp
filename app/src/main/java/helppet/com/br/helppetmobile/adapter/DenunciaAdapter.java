package helppet.com.br.helppetmobile.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.modelo.Denuncia;

/**
 * Created by josafa on 16/05/17.
 */

public class DenunciaAdapter extends BaseAdapter {

    public DenunciaAdapter(Context context, ArrayList<Denuncia> listaDenuncias) {
        this.context = context;
        this.listaDenuncias = listaDenuncias;
    }

    private Context context;
    private ArrayList<Denuncia> listaDenuncias;

    @Override
    public int getCount() {
        return listaDenuncias.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDenuncias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Denuncia denuncia = listaDenuncias.get(position);

        View viewRetorno = LayoutInflater.from(context).inflate(R.layout.activity_denuncias, parent, false);
        TextView descricaoDenuncia = (TextView) viewRetorno.findViewById(R.id.descricaoDenuncia);
        TextView tipoDenuncia = (TextView) viewRetorno.findViewById(R.id.tipoDenuncia);
        TextView localDenuncia = (TextView) viewRetorno.findViewById(R.id.localDenuncia);
        TextView tituloDenuncia = (TextView) viewRetorno.findViewById(R.id.tituloDenuncia);

        descricaoDenuncia.setText(denuncia.getDescricao());
        tipoDenuncia.setText(denuncia.getTipo());
        localDenuncia.setText(denuncia.getLocalizacao());
        tituloDenuncia.setText(denuncia.getTitulo());

        return viewRetorno;
    }
}

