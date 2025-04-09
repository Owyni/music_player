package ListasDobles;

public class Cancion {
    private String titulo;
    private String artista;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public String toString() {
        return "\"" + titulo + "\" de " + artista;
    }
}
