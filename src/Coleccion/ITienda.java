package Coleccion;

import Base.Animal;
import Exceptions.TiendaException;

import java.util.Iterator;

public interface ITienda {

    //Throws significa que la excepcion la elevamos al try catch del llamante y ya se encarga el de tratarlo

    public void InsertarAnimal(Animal animal) throws TiendaException; //Podríamos poner ITiendaException
    //La opción easy es capturar internamente con try catch y devolver un boolean

    public void EliminarPorCodigo(String codigo) throws TiendaException;
    public void EliminarTodosPorNombre (String nombre) throws TiendaException;
    public Iterator AnimalesEnTienda() throws TiendaException;
}
