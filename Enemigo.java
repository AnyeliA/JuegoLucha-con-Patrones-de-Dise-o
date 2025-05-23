/**
 * Clase que representa a un personaje de tipo Enemigo en el juego.
 * 
 * Esta clase hereda de la clase Personaje y se inicializa con el ataque
 *  BolaFuego como su estrategia de ataque predeterminada.
 * 
 * Forma parte del patrón de diseño Strategy, donde el ataque es una
 * estrategia intercambiable. También aplica el principio de herencia
 * como parte del uso de POO.
 */
public class Enemigo extends Personaje {

    /**
     * Constructor que crea un Enemigo con un nombre específico y le asigna
     * por defecto el ataque BolaFuego.
     * 
     * nombre El nombre del enemigo.
     */
    public Enemigo(String nombre) {
        super(nombre, new BolaFuego());
    }

    /**
     * Devuelve una representación en texto del estado actual del enemigo,
     * incluyendo su tipo, nombre y vida restante.
     * 
     *  Cadena de texto con el formato: "[nombre] [Enemigo] - Vida: [vida]"
     */
   
    public String mostrar() {
        return " " + nombre + " [Enemigo] - Vida: " + vida;
    }
}
