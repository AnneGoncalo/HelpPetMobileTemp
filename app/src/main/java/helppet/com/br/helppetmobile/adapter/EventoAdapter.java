package helppet.com.br.helppetmobile.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import helppet.com.br.helppetmobile.R;
import helppet.com.br.helppetmobile.modelo.Evento;

/**
 * Created by aluno on 18/05/17.
 */

public class EventoAdapter extends BaseAdapter {
    public EventoAdapter(Context context, ArrayList<Evento> listaEventos) {
        this.context = context;
        this.listaEventos = listaEventos;
    }

    private Context context;
    private ArrayList<Evento> listaEventos;

    @Override
    public int getCount() {
        return listaEventos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Evento evento = listaEventos.get(position);

        View viewRetorno = LayoutInflater.from(context).inflate(R.layout.activity_eventos, parent, false);
        TextView nomeEvento = (TextView) viewRetorno.findViewById(R.id.nomeEvento);
        TextView dataEvento = (TextView) viewRetorno.findViewById(R.id.dataEvento);
        TextView horarioEvento = (TextView) viewRetorno.findViewById(R.id.horarioEvento);
        TextView localEvento = (TextView) viewRetorno.findViewById(R.id.localEvento);

        nomeEvento.setText(evento.getNome());
        dataEvento.setText(evento.getData());
        horarioEvento.setText(evento.getHorario());
        localEvento.setText(evento.getLocalizacao());

        return viewRetorno;
    }
}
