//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//clase cuenta que contiene una variable de instancia llamada nombre

public class Main {
    private String nombre;  // Corregido: Private -> private, string -> String

    // método para establecer el nombre en el objeto
    public void establecerNombre(String nombre) {
        this.nombre = nombre;  // Movido dentro del metodo
    }

    public String obtenerNombre() {  // Corregido: pubic -> public, string -> String
        return nombre;
    }
}