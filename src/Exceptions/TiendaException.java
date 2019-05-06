package Exceptions;

import Constantes.Shared;

import static Constantes.Shared.DEFAULT_ERR_MESSAGE;

public class TiendaException extends Exception{

    public TiendaException()
    {
        this(Shared.DEFAULT_ERR);
    }

    public TiendaException(int errCode)
    {
        this(errCode,DEFAULT_ERR_MESSAGE); // O lo que es lo mismo "" + errCode
    }

    public TiendaException(int errCode, String mensaje) //Hay veces que se deja un custom mensaje hardcodeado
    {
        super(String.valueOf(errCode) + " -> " + mensaje);
    }
}
