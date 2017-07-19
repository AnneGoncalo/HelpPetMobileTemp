package helppet.com.br.helppetmobile.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import helppet.com.br.helppetmobile.modelo.Denuncia;

/**
 * Created by josafa on 23/05/17.
 */

public class DenunciaDAO {

    public DenunciaDAO(Context context) {
        DataBase databese = new DataBase(context);
        this.conn = databese.getWritableDatabase();

    }

    private SQLiteDatabase conn;


    public void inserir(Denuncia denuncia) {

        ContentValues values = new ContentValues();
        values.put("titulo", denuncia.getTitulo());
        values.put("local", denuncia.getLocalizacao());
        values.put("descricao", denuncia.getDescricao());
        values.put("tipo", denuncia.getTipo());
        conn.insert("denuncias", null, values);

    }

    public void excluir(Denuncia denuncia) {
        conn.delete("denuncias", " _id= ?", new String[]{String.valueOf(denuncia.getId())});
    }

    /*public void alterar(Denuncia aula, Context context) {
        ContentValues values = new ContentValues();
        values.put("data_aula", aula.getData());
        values.put("hora_aula", aula.getHora());
        values.put("nome_instrutor", aula.getNomeInstrutor());

        int i = conn.update("nocaoFuncionamento", values, "_id= ?", new String[]{String.valueOf(aula.get_id())});

    }*/

    public ArrayList<Denuncia> buscarDenuncia() {

        ArrayList<Denuncia> retorno = new ArrayList<>();
        Cursor cursor = conn.query("denuncias", null, null, null, null, null, null);

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                Denuncia denuncia = new Denuncia();
                denuncia.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                denuncia.setTitulo(cursor.getString(1));
                denuncia.setLocalizacao(cursor.getString(2));
                denuncia.setTipo(cursor.getString(3));
                denuncia.setDescricao(cursor.getString(4));

                retorno.add(denuncia);
            } while (cursor.moveToNext());

        }
        return retorno;
    }

}
