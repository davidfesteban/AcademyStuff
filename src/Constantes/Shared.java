package Constantes;

public final class Shared {

    //Region te permite acotar de forma más visible un conjunto

    //region Utilidades
    public static final int LONGITUD_DE_RESPONSE = 4;
    public static final char DEFAULT_CHAR = '0';
    //endregion

    //region Atributos
    public static final int DEFAULT_EDAD = 5; // AÑOS
    public static final int DEFAULT_TAMANYO = 100; //CM  NUNCA UNA Ñ EN EL CÖDIGO
    public static final int DEFAULT_MIN_TAMANYO = 10; //CM Un animal menor de 10 cm MERECE MORIR
    //endregion

    //region Errores
    public static final int DEFAULT_ERR = 418; // Error desconocido
    public static final int DEFAULT_ERR_NULL = 101; // He recibido o tengo un null en algun objeto
    public static final int DEFAULT_ERR_EMPTY = 102; // El objeto está vacio
    public static final int DEFAULT_ERR_FORMAT = 103; // Fallo en el error de formato
    public static final String DEFAULT_ERR_MESSAGE = "NO DATA"; //Mensaje por defecto
    //endregion
}
