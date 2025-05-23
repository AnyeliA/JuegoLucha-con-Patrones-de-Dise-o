import java.util.Random;

/**
 * Clase que representa un ataque de tipo "Bola de Fuego".
 * 
 * Esta clase implementa la interfaz {@link Ataque}, y define un ataque que
 * inflige un daño aleatorio entre 15 y 30 puntos.
 * 
 * Se utiliza dentro del juego para asignar este tipo de comportamiento ofensivo
 * a los personajes que usen este ataque.
 */
public class BolaFuego implements Ataque {

    // Generador de números aleatorios para calcular el daño
    private final Random rand = new Random();

    /**
     * Ejecuta el ataque y devuelve el daño infligido.
     * 
     * @return un valor de daño aleatorio entre 15 y 30
     */
    @Override
    public int ejecutar() {
        return rand.nextInt(16) + 15; // devuelve un número entre 15 y 30
    }

    /**
     * Devuelve el nombre del ataque.
     * 
     * @return el nombre "Bola de Fuego"
     */
    @Override
    public String getNombre() {
        return "Bola de Fuego";
    }
}
