package helppet.com.br.helppetmobile.util;

/**
 * Created by josafa on 16/05/17.
 */

public  class  Path {
    //private static String api = "http://10.24.12.128:8080/HelpPet/rest/";
    private static String api = "http://10.0.0.107:8080/HelpPet/rest/";
    private static String denunciaPath = api + "denuncia";
    private static String eventoPath = api + "evento";
    private static String anuncioPath = api + "anuncio";
    private static String ongPath = api + "ong";
    private static String clinicaPath = api + "clinica";
    private static String experienciaPath = api + "experiencia";

    public static String getDenunciaPath() {
        return denunciaPath;
    }

    public static String getEventoPath() { return eventoPath; }

    public static String getAnuncioPath() { return anuncioPath; }

    public static String getOngPath() { return ongPath; }

    public static String getClinicaPath() { return clinicaPath; }

    public static String getExperienciaPath() { return experienciaPath; }
}
