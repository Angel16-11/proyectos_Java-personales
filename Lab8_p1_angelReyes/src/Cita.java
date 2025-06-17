// Cita.java
public class Cita {
    private String nombreCliente;
    private String servicio;
    private String fecha;
    private String estado;

    // Constructor vacío
    public Cita() {
    }

    // Constructor con parámetros
    public Cita(String nombreCliente, String servicio, String fecha, String estado) {
        this.nombreCliente = nombreCliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Para imprimir rápidamente una cita
    @Override
    public String toString() {
        return "Cliente: " + nombreCliente +
                " | Servicio: " + servicio +
                " | Fecha: " + fecha +
                " | Estado: " + estado;
    }
}

