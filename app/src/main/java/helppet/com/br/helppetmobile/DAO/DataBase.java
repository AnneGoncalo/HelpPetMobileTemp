package helppet.com.br.helppetmobile.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by josafa on 23/05/17.
 */

public class DataBase extends SQLiteOpenHelper {


    public DataBase(Context context) {
        super(context, "banco", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Script.tabelaDenuncia());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


