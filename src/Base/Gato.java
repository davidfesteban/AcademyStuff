package Base;

import Constantes.Shared;

public class Gato extends Animal {

    //Así es como lo voy a hacer en vez de private final static int DEFAULT_EDAD
    private int edad = Shared.DEFAULT_EDAD;

    public Gato()
    {
        // Te ahorras hacer el this(Shared.DEFAULT_EDAD, "");
        super();
    }

    public Gato(int edad)
    {
        this(edad, ""); // MALA PRACTICA, al no haber hecho el shared no puedo pasarle el DEFAULT_NOMBRE;
        //Aunque llevo el control en Animal por si viene vacio el nombre, no es correcto.
        // OJO, el control del null se lo haré en la entrada de datos
    }

    public Gato(int edad, String nombre)
    {
        super(nombre);
        if(edad < 0)
        {
            edad = Shared.DEFAULT_EDAD;
        }

        this.edad = edad;
    }

    @Override
    public String toString() { //Lo dicho, se puede meter en el shared(otro) de String en xml o a pelo.
        return "Gato{" +
                "edad=" + edad +
                super.toString() + "}";
    }
}
