package Base;

import Constantes.Shared;

public class Perro extends Animal {

    private int tamanyo = Shared.DEFAULT_TAMANYO;

    public Perro()
    {
        super();
    }

    public Perro(int tamanyo)
    {
        this(tamanyo, ""); //NO HAGO CONTRUCTOR Perro(String nombre) lo considero tonteria aunque necesario
        //para buena praxis aunque llena mucho el código de constructores tontos. Si no sabes ni el aprox de tamaño
        //de tu animal, enserio te sabes el nombre (?) jajajaja
    }

    public Perro(int tamanyo, String nombre)
    {
        super(nombre); // el super SIEMPRE en la primera linea
        if(tamanyo < Shared.DEFAULT_MIN_TAMANYO)
        {
            tamanyo = Shared.DEFAULT_EDAD; //Esta técnica en c++ o ensamblador estaría prohibida
        }        //Debido a que SI SE USAN punteros. No pseudo-punteros automatizados por detrás.

        this.tamanyo = tamanyo;
    }

    @Override
    public String toString() { //Se podría meter en el shared pero ya es mucha tralla para vosotros.
        return "Perro{" +
                "tamanyo=" + tamanyo +
                super.toString() + "}"; //Colmo de la vaguería y acoplo un poco pero es OK y elegante.
    }
}
