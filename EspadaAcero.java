import java.util.Random;

/**
 * Clase que representa el ataque "Espada de Acero".
 * 
 * Esta clase implementa la interfaz {@link Ataque} y define una estrategia
 * concreta de ataque que genera un daño aleatorio entre 10 y 30 puntos.
 * 
 * Forma parte del patrón de diseño Strategy, permitiendo que los personajes
 * puedan cambiar de tipo de ataque dinámicamente en tiempo de ejecución.
 */
public class EspadaAcero implements Ataque {
    
    // Generador de números aleatorios para calcular el daño del ataque.
    private final Random rand = new Random();

    /**
     * Ejecuta el ataque calculando un valor de daño aleatorio.
     *
     * Cantidad de daño entre 10 y 30.
     */
   
    public int ejecutar() {
        return rand.nextInt(21) + 10; // Devuelve un número entre 10 y 30
    }

    /**
     * Devuelve el nombre del ataque.
     *
     *  "Espada de Acero"
     */
  
    public String getNombre() {
        return "Espada de Acero";
    }
}
