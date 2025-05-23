// Importa clases para manejar fechas y tiempos.
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

// Clase que representa a un jugador con vidas, monedas y un sistema de recarga de vidas.
public class Jugador {
    // Número actual de vidas del jugador.
    private int vidas;

    // Número actual de monedas del jugador.
    private int monedas;

    // Fecha y hora de la última vez que se intentó recargar vidas.
    private LocalDateTime ultimaRecarga;

    // Constante: número máximo de vidas que un jugador puede tener.
    private final int MAX_VIDAS = 5;

    // Constante: tiempo necesario (en minutos) para recargar una vida.
    private final int TIEMPO_RECARGA_MINUTOS = 10;

    // Constructor que inicializa un jugador con vidas completas y sin monedas.
    public Jugador() {
        this.vidas = MAX_VIDAS;
        this.monedas = 0;
        this.ultimaRecarga = LocalDateTime.now(); // Se guarda el momento actual como última recarga.
    }

    // Método que verifica si el jugador puede jugar (tiene vidas).
    // También intenta recargar vidas automáticamente si ha pasado suficiente tiempo.
    public boolean puedeJugar() {
        recargarVidasSiEsNecesario();
        return vidas > 0;
    }

    // Método que simula jugar una partida y actualiza las vidas y monedas del jugador.
    public void jugarPartida(boolean gano) {
        if (!puedeJugar()) {
            System.out.println("No tienes vidas. Espera o compra más.");
            return;
        }

        // Resta una vida por haber jugado.
        vidas--;
        System.out.println("Jugaste una partida. Vidas restantes: " + vidas);

        // Si ganó, se le suman monedas.
        if (gano) {
            monedas += 10;
            System.out.println("¡Ganaste! Monedas actuales: " + monedas);
        } else {
            System.out.println("Perdiste. Monedas actuales: " + monedas);
        }
    }

    // Método que permite al jugador comprar una vida a cambio de monedas.
    public void comprarVida() {
        int costo = 20; // Costo de una vida en monedas

        // Solo se permite comprar si el jugador tiene suficientes monedas y no está en el máximo de vidas.
        if (monedas >= costo && vidas < MAX_VIDAS) {
            monedas -= costo;
            vidas++;
            System.out.println("Compraste una vida. Vidas: " + vidas + ", Monedas: " + monedas);
        } else {
            System.out.println("No puedes comprar vida. Revisa tus monedas o si ya tienes vidas al máximo.");
        }
    }

    // Método privado que revisa si ha pasado suficiente tiempo para recargar vidas automáticamente.
    private void recargarVidasSiEsNecesario() {
        // Calcula los minutos que han pasado desde la última recarga.
        long minutosPasados = ChronoUnit.MINUTES.between(ultimaRecarga, LocalDateTime.now());

        // Determina cuántas vidas se pueden recargar (una cada X minutos).
        int vidasARecargar = (int)(minutosPasados / TIEMPO_RECARGA_MINUTOS);

        // Si hay vidas por recargar y el jugador no tiene todas, se recargan.
        if (vidasARecargar > 0 && vidas < MAX_VIDAS) {
            vidas = Math.min(vidas + vidasARecargar, MAX_VIDAS);
            ultimaRecarga = LocalDateTime.now(); // Se actualiza la última recarga
            System.out.println("Vidas recargadas automáticamente. Ahora tienes: " + vidas);
        }
    }

    // Getter para obtener cuántas vidas tiene actualmente el jugador.
    public int getVidas() {
        return vidas;
    }

    // Getter para obtener cuántas monedas tiene actualmente el jugador.
    public int getMonedas() {
        return monedas;
    }
}
