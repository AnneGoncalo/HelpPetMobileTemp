package helppet.com.br.helppetmobile.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.modelo.Experiencia;

/**
 * Created by anne on 19/05/17.
 */

public class ExperienciaAdapter extends BaseAdapter {
    public ExperienciaAdapter(Context context, ArrayList<Experiencia> lista) {
        this.context = context;
        this.lista = lista;
    }

    private Context context;
    private ArrayList<Experiencia> lista;

    @Override
    public int getCount() { return lista.size(); }

    @Override
    public Object getItem(int position) { return lista.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Experiencia experiencia = lista.get(position);

        View viewRetorno = LayoutInflater.from(context).inflate(R.layout.activity_experiencias, parent, false);
        TextView tituloExperiencia = (TextView) viewRetorno.findViewById(R.id.tituloExperiencia);
        TextView tipoExperiencia = (TextView) viewRetorno.findViewById(R.id.tipoExperiencia);
        TextView textoExperiencia = (TextView) viewRetorno.findViewById(R.id.textoExperiencia);

        tituloExperiencia.setText(experiencia.getTituloExperiencia());
        tipoExperiencia.setText(experiencia.getTipoExperiencia());
        textoExperiencia.setText(experiencia.getTexto());

        return viewRetorno;
    }
}
