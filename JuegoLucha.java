import java.util.Random;
import java.util.Scanner;

/**
 * Esta clase representa el motor principal del juego de lucha.
 * 
 * Se encarga de iniciar el juego, asignar personajes aleatorios a los jugadores,
 * mostrar el estado de los luchadores y controlar los turnos hasta que uno gane.
 * 
 * En este juego, dos personajes (jugador1 y jugador2) se enfrentan en una batalla
 * donde pueden atacar o curarse. El combate continúa hasta que uno pierde toda su vida.
 */
public class JuegoLucha {

    private Personaje jugador1;
    private Personaje jugador2;

    /**
     * Método principal para iniciar el juego.
     * Pide los nombres de los jugadores, asigna un personaje aleatorio a cada uno,
     * muestra sus datos y ejecuta la batalla por turnos.
     */
    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al Juego donde si no te pones las pilas Cano te elimina");
        System.out.println("Intro!! El poder es para abusar de él, sino ¿para qué poder?");

        // Se selecciona un personaje aleatorio para cada jugador
        jugador1 = seleccionarPersonajeAleatorio(sc, 1);
        jugador2 = seleccionarPersonajeAleatorio(sc, 2);

        System.out.println("\n--- ¡Empieza la batalla! ---\n");
        System.out.println(jugador1.mostrar());
        System.out.println(jugador2.mostrar());

        // Comienza el combate por turnos hasta que uno de los dos pierda
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            turno(jugador1, jugador2); // turno del jugador1
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1); // turno del jugador2, si sigue vivo
            }
        }

        // Resultado final del juego
        System.out.println("\n--- FIN DE LA PELEA ---");
        if (jugador1.estaVivo()) {
            System.out.println(" " + jugador1.getNombre() + " ha ganado.");
        } else {
            System.out.println(" " + jugador2.getNombre() + " ha ganado.");
        }
    }

    /**
     * Representa un turno de pelea entre un atacante y un defensor.
     * El atacante decide aleatoriamente si ataca o se cura.
     * 
     */
    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("\nTurno de " + atacante.getNombre());
        Random rand = new Random();

        // Con un 20% de probabilidad se cura (si no lo ha hecho antes), y 80% ataca
        if (!atacante.usoCuracion && rand.nextInt(100) < 20) {
            atacante.curar();
        } else {
            atacante.atacar(defensor);
        }

        // Se muestra el estado del defensor después del turno
        System.out.println(defensor.mostrar());
    }

    
    private Personaje seleccionarPersonajeAleatorio(Scanner sc, int numero) {
        System.out.print("Nombre del Jugador " + numero + ": ");
        String nombre = sc.nextLine();

        FabricaPersonaje fabrica;
        boolean esLuchador = new Random().nextBoolean(); // Decide aleatoriamente el tipo
        if (esLuchador) {
            fabrica = new FabricaLuchador();
            System.out.println("Rol asignado aleatoriamente: Luchador");
        } else {
            fabrica = new FabricaEnemigo();
            System.out.println("Rol asignado aleatoriamente: Enemigo");
        }

        // Se crea el personaje con el nombre dado
        return fabrica.crearPersonaje(nombre);
    }
}