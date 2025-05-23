/**
 * Interfaz que representa un tipo de ataque en el juego.
 * 
 * Las clases que implementen esta interfaz deben definir el comportamiento
 * específico del ataque, como su daño y su nombre.
 * 
 * Esto permite aplicar el patrón de diseño Strategy para intercambiar ataques
 * dinámicamente entre personajes.
 */
public interface Ataque {

    /**
     * Ejecuta el ataque y devuelve el daño que inflige.
     *
     * @return cantidad de daño que realiza este ataque
     */
    int ejecutar();

    /**
     * Devuelve el nombre del ataque.
     *
     * @return nombre o descripción del ataque
     */
    String getNombre();
}
