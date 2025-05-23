/**
 * Clase concreta que implementa la creación de personajes tipo Enemigo.
 * 
 * Esta clase extiende  FabricaPersonaje y redefine el método
 *  crearPersonaje para devolver una instancia específica de  Enemigo.
 * 
 * Forma parte del patrón de diseño Factory Method, permitiendo encapsular
 * la creación de objetos de tipo personaje sin acoplar el código a clases concretas.
 */
public class FabricaEnemigo extends FabricaPersonaje {

    /**
     * Crea y devuelve un nuevo personaje del tipo Enemigo.
     *
     * El nombre del personaje enemigo.
     *  Una nueva instancia de {@link Enemigo}.
     */
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Enemigo(nombre);
    }
}
