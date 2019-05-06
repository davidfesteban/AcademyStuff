package Coleccion;

import Base.Animal;
import Exceptions.TiendaException;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static Constantes.Shared.*;

public class Tienda implements ITienda {

            // Codigo, Animal
    private Map<String, Animal> animalesTienda = null;

    public Tienda()
    {
        this(new TreeMap<String, Animal>());
    }

    public Tienda(Map<String,Animal> otraTienda)
    {
        animalesTienda = new TreeMap<String,Animal>(otraTienda); //Importante new y no directamente = otraTienda
        // debido a que a pesar de ser por parametro, se pueden referenciar los objetos
    }

    //region FuncionalidadesITIENDA

    @Override
    public void InsertarAnimal(Animal animal) throws TiendaException {
        if(animal != null) {
            animalesTienda.put(animal.getCodigo(),animal);
        }else if(animal == null)
        {
            throw new TiendaException(DEFAULT_ERR_NULL,"Error Animal null");
        }else
        {
            throw new TiendaException(DEFAULT_ERR);
        }
    }

    @Override
    public void EliminarPorCodigo(String codigo) throws TiendaException {
        //EliminarPorCodigo sigue elevando las excepciones de CommonDefault
        if(!EliminarCommonDefault(codigo) || codigo.length() != LONGITUD_DE_RESPONSE)
        {
            throw new TiendaException(DEFAULT_ERR_FORMAT,"Error Codigo Longitud erronea");

        }else if(!animalesTienda.containsKey(codigo))
        {
            //Esta opcion se puede complementar mediante un boolean en ElimnarPorCodigo
            throw new TiendaException(DEFAULT_ERR,"Error Animal no encontrado");
        }else
        {
            animalesTienda.remove(codigo);
        }
    }

    @Override
    public void EliminarTodosPorNombre(String nombre) throws TiendaException {

        if(!EliminarCommonDefault(nombre) || !animalesTienda.containsValue(nombre))
        {
            //Esta opcion se puede complementar mediante un boolean en ElimnarPorCodigo
            throw new TiendaException(DEFAULT_ERR,"Error Animal no encontrado");
        }else
        {
            Iterator animales = AnimalesEnTienda();
            while(animales.hasNext())
            {
                if(((Animal)animales.next()).getNombre().equals(nombre));
                {
                    animales.remove();
                }
            }
        }
    }

    private boolean EliminarCommonDefault( String data ) throws TiendaException //METODO PARA UNIFICAR AMBOS
    {
        boolean result = false;

        if(data == null)
        {
            throw new TiendaException(DEFAULT_ERR_NULL,"Error null");

        }else if(data.isEmpty())
        {
            throw new TiendaException(DEFAULT_ERR_EMPTY,"Error vacio");

        }else if(animalesTienda.isEmpty())
        {
            throw new TiendaException(DEFAULT_ERR_EMPTY,"Error Tienda vacia");

        }else
        {
            result = true;
        }

        return result;

    }

    @Override
    public Iterator AnimalesEnTienda() throws TiendaException {
        Iterator animalesIterator = null;
        if(animalesTienda.isEmpty() || animalesTienda == null)
        {
            throw new TiendaException(DEFAULT_ERR_EMPTY,"Collection vacia");
        }
        else
        {
            animalesIterator = ((TreeMap)animalesTienda).values().iterator();
        }
        return animalesIterator;
    }

    //endregion
}
