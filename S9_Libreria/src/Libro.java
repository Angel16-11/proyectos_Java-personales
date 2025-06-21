
public class Libro {
    private String Nombre;
    private String Autor;
    private int Estado;

    public Libro() {
    }

    public Libro(String Nombre, String Autor, int Estado) {
        this.Nombre = Nombre;
        this.Autor = Autor;
        this.Estado = Estado;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String toString() {
        return "" + Nombre + "\t" + Autor;
    }

}