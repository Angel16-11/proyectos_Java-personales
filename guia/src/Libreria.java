
class Libreria {
    private String titulo;
    private String autor;
    private int fila;
    private int columna;

    public Libreria(String titulo, String autor, int fila, int columna) {
        this.titulo = titulo;
        this.autor = autor;
        this.fila = fila;
        this.columna = columna;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
