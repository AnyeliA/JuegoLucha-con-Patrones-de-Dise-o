// Importa la clase Scanner para leer datos ingresados por el usuario desde la consola.
import java.util.Scanner;

// Clase principal que contiene el punto de entrada del programa.
public class Main {
    
    // Método principal donde comienza la ejecución del programa.
    public static void main(String[] args) {
        // Se crea un objeto Scanner para leer entrada del usuario.
        Scanner scanner = new Scanner(System.in);

        // Se crea un nuevo jugador con vidas y monedas iniciales.
        Jugador jugador = new Jugador();

        // Bucle infinito que muestra el menú hasta que el usuario decida salir.
        while (true) {
            // Muestra las opciones disponibles al jugador.
            System.out.println("\n=== MENÚ DEL JUEGO ===");
            System.out.println("1. Jugar partida");
            System.out.println("2. Comprar una vida (20 monedas)");
            System.out.println("3. Mostrar estado del jugador");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            // Lee la opción elegida por el usuario.
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del Scanner para evitar errores con nextLine.

            // Estructura de control que ejecuta acciones según la opción elegida.
            switch (opcion) {
                
                // Opción 1: Jugar una partida.
                case 1:
                    // Verifica si el jugador tiene vidas para jugar.
                    if (jugador.puedeJugar()) {
                        // Se crea e inicia una partida del juego de lucha.
                        JuegoLucha juego = new JuegoLucha();
                        juego.iniciar();
                        
                        // Resultado aleatorio de la partida (50% ganar o perder).
                        boolean gano = Math.random() < 0.5;

                        // Se registra el resultado de la partida (ganó o perdió).
                        jugador.jugarPartida(gano);
                    } else {
                        // Si no tiene vidas, se le avisa al jugador.
                        System.out.println("⚠ No puedes jugar. No tienes vidas.");
                        jugador.mostrarTiempoParaRecarga(); // Opción extra para mostrar cuándo podrá jugar de nuevo.
                    }
                    break;

                // Opción 2: Comprar una vida usando monedas.
                case 2:
                    jugador.comprarVida();
                    break;

                // Opción 3: Mostrar el estado actual del jugador (vidas y monedas).
                case 3:
                    System.out.println("❤ Vidas: " + jugador.getVidas());
                    System.out.println("💰 Monedas: " + jugador.getMonedas());
                    break;

                // Opción 4: Salir del juego.
                case 4:
                    System.out.println("Gracias por jugar.");
                    return; // Termina el programa.

                // Cualquier otra opción no válida.
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

