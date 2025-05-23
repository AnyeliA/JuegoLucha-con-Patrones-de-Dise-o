/**
 * Clase abstracta que representa un personaje del juego.
 * 
 * Cada personaje tiene un nombre, una cantidad de vida, un tipo de ataque,
 * y puede realizar acciones como atacar a otro personaje o curarse.
 * 
 * Esta clase es abstracta, lo que significa que no se puede crear directamente,
 * sino que debe ser heredada por otras clases (como Luchador o Enemigo).
 */
public abstract class Personaje {

    protected String nombre; // Nombre del personaje
    protected int vida = 130; // Vida inicial del personaje
    protected Ataque ataque; // Tipo de ataque que puede usar
    protected boolean usoCuracion = false; // Indica si ya usó su curación

    /**
     * Constructor que recibe el nombre del personaje y su tipo de ataque.
     * 
     */
    public Personaje(String nombre, Ataque ataque) {
        this.nombre = nombre;
        this.ataque = ataque;
    }

    /**
     * Permite al personaje atacar a otro personaje.
     * Calcula el daño del ataque, se lo aplica al oponente y muestra un mensaje.
     * 
     */
    public void atacar(Personaje oponente) {
        int dano = ataque.ejecutar(); // Se calcula el daño con el método del ataque
        oponente.recibirDano(dano); // Se aplica el daño al oponente
        System.out.println(nombre + " ataca a " + oponente.getNombre() +
                " usando " + ataque.getNombre() + ", causando " + dano + " de daño.");
    }

    /**
     * Resta vida al personaje cuando recibe un ataque.
     * La vida no puede bajar de cero.
     * 
     */
    public void recibirDano(int dano) {
        vida = Math.max(vida - dano, 0); // Evita que la vida sea menor a 0
    }

    /**
     * Permite al personaje curarse una sola vez durante la pelea.
     * Suma 40 puntos de vida, sin pasarse del máximo (130).
     */
    public void curar() {
        if (!usoCuracion) {
            vida = Math.min(vida + 40, getMaxVida());
            usoCuracion = true;
            System.out.println(nombre + " ha usado una poción de curación (+40 vida).");
        } else {
            System.out.println(nombre + " ya usó su curación y no puede volver a hacerlo.");
        }
    }

    /**
     * Indica si el personaje sigue con vida (vida mayor a cero).
     * 
     */
    public boolean estaVivo() {
        return vida > 0;
    }

    /**
     * Devuelve el nombre del personaje.
     * 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la cantidad actual de vida del personaje.
     * 
     */
    public int getVida() {
        return vida;
    }

    /**
     * Devuelve la cantidad máxima de vida que puede tener el personaje.
     * 
     */
    public int getMaxVida() {
        return 130;
    }

    
    public abstract String mostrar();
}