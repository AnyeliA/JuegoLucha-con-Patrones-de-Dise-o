/**
 * Esta clase representa una fábrica que se encarga de crear personajes del tipo Luchador.
 * 
 * Forma parte del patrón de diseño Abstract Factory, y se especializa en construir
 * personajes específicos (en este caso, luchadores).
 * 
 * Hereda de la clase FabricaPersonaje, que define el método abstracto para crear personajes.
 */
public class FabricaLuchador extends FabricaPersonaje {

    
    public Personaje crearPersonaje(String nombre) {
        return new Luchador(nombre);
    }
}