package helppet.com.br.helppetmobile.DAO;

/**
 * Created by josafa on 23/05/17.
 */

public class Script {


    public static String tabelaDenuncia() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("create table if not exists denuncias( ");
        retorno.append("_id integer not null primary key autoincrement, ");
        retorno.append("titulo varchar (255) ,");
        retorno.append("local varchar (255) ,");
        retorno.append("tipo varchar (255) ,");
        retorno.append("descricao varchar (255)");
        retorno.append(");");
        return retorno.toString();
    }


}
