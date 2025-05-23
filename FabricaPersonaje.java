/**
 * Esta es una clase abstracta que representa una fábrica de personajes.
 * 
 * Sirve como base para otras clases que van a crear diferentes tipos de personajes,
 * La clase define un método abstracto llamado crearPersonaje, que debe ser
 * implementado por cada subclase con la lógica específica para crear ese tipo de personaje.
 */
public abstract class FabricaPersonaje {

    public abstract Personaje crearPersonaje(String nombre);
}
