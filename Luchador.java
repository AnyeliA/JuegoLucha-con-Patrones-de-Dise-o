public class Luchador extends Personaje {
    public Luchador(String nombre) {
        super(nombre, new EspadaAcero());
        this.vida = 130;
    }

    @Override
    public String mostrar() {
        return " " + nombre + " [Luchador] - Vida: " + vida;
    }
}