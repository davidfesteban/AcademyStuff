package Base;


import Utilidades.Utilidades;

import java.util.Objects;

// Podría hacerle una interfaz pero no lo veo necesario ya que solo usa su comportamiento, no a terceros

public class Animal {

    /* Se podría llevar a un recurso Shared.json o .java en vez de hardcodearlo. Es static para evitar llamar a Object.
        Es el unico ejemplo que vais a ver para poner constantes así
     */
    private final static String DEFAULT_NOMBRE = "Pollita";

    private String nombre = ""; // En C# sería _nombre
    private String codigo = ""; // Es buena practica inicializar siempre que se pueda
    private static int ordenCreacion = 0; // Recurso compartido entre todas las clases del mismo tipo

    public Animal()
    {
        this(DEFAULT_NOMBRE);
    }

    public Animal(String nombre)  //NOTA: podríamos hacer super() pero lo hace por defecto JAVA
    {
        if(nombre.isEmpty())
        {
            nombre = DEFAULT_NOMBRE; //Si es vacio, usa el por defecto.
        }

        this.nombre = new String(nombre); // No hace falta pero para que veais que un string se crea así.

        /*
            Sumo uno al static ordenCreacion (ya que empezamos en 1) y se lo meto. En las empresas se evita
            el uso de los static bajo excepciones y penas de muerte. Se suele usar el patrón Singleton cosa que no voy
            a hacer para liaros más
         */
        this.codigo = new Utilidades().EnteroAString4Coverter(++ordenCreacion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    @Override //AUTO-GENERATED
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(nombre, animal.nombre) &&
                Objects.equals(codigo, animal.codigo);
    }

    @Override //AUTO-GENERATED
    public int hashCode() {

        return Objects.hash(nombre, codigo);
    }

    public int compareTo(Animal otroAnimal) //Lo necesitamos por el TreeMap de Tienda (aunque no obligatorio
    {
        return codigo.compareTo(otroAnimal.codigo); //Podemos hacerlo porque estamos en la misma clase
    }
}
