package Utilidades;

import static Constantes.Shared.DEFAULT_CHAR;
import static Constantes.Shared.LONGITUD_DE_RESPONSE;

public class Utilidades implements IUtilidades{

    /*
        Incorporo interfaz para seguir los standars de Clean Code. Si el profesor se pone quisquilloso,
        podeis quitar la interfaz.

        Veréis a lo largo de todas las clases que intento hacerlo de manera simple pero eficaz sin usar cosas que
        considero que no habéis visto o no son necesarias.

        En este caso no hace falta constructor ya que estamos hablando de una simple pseudo-libreria de funciones
        con utilidades y tiramos entonces del de paquete base (object)
     */

    @Override
    public String EnteroAString4Coverter(int numero) {
        /* Uso un StringBuilder porque le vamos a hacer perrerías a la cadena, se podría haber hecho en cuatro lineas
           incorporando una máscara de entrada para forzar que sean 4 carácteres */
        StringBuilder result =  new StringBuilder("");
        StringBuilder temp = new StringBuilder("");

        //Paso el numero a positivo y lo añado al temp
        temp.append(Math.abs(numero));

        //Longitud de response y result length (tiene que ir la primera) para comprobar tamaño y seleccionar.
        int i = 0;
        while(i<result.length() && i<LONGITUD_DE_RESPONSE)
        {
            result.append(temp.charAt(result.length()-1-i)); //Para empezar por el final
        }

        //Si no llegamos a cuatro caracteres, llena de ceros a la izq. No hace falta el if.
        for(int j=result.length(); j<LONGITUD_DE_RESPONSE; ++j)
        {
            result.append(DEFAULT_CHAR);
        }

        return result.toString();
    }

}
