

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class Lab9_P1_AngelReyes {

    static Random R = new Random();
    static ArrayList<Medicina> inventario = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1 -> crearMedicina();
                case 2 -> listarMedicinas();
                case 3 -> eliminarMedicina();
                case 4 -> editarMedicina();
                case 5 -> atenderPaciente();
                case 0 -> JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 0);
    }

    // ---------------- MENÚ ----------------
    private static int mostrarMenu() {
        String menu = """
                --- Clínica del Palacio Interior ---
                1. Crear medicina
                2. Listar medicinas disponibles
                3. Eliminar medicina
                4. Editar medicina
                5. Atender paciente
                0. Salir
                Ingrese opción:""";
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(menu));
        } catch (Exception e) {
            return -1; // fuerza “opción inválida”
        }
    }

    // ------------- OPCIÓN 1 ---------------
    private static void crearMedicina() {
        String nombre = JOptionPane.showInputDialog("Nombre de la medicina:");
        String tipo = JOptionPane.showInputDialog("Tipo / presentación (tabletas, jarabe, etc.):");

        // Validar enfermedad
        String enfermedad;
        do {
            enfermedad = JOptionPane.showInputDialog("""
                    Enfermedad que trata:
                    1. Fiebres
                    2. Infecciones
                    3. Envenenamientos
                    4. Sarpullidos
                    Ingrese el nombre EXACTO (sin comillas):""");
        } while (!esEnfermedadValida(enfermedad));

        int cantidad = leerEnteroPositivo("Cantidad en existencia:");
        String origen = JOptionPane.showInputDialog("Origen (natural, sintético, etc.):");

        inventario.add(new Medicina(nombre, tipo, enfermedad, cantidad, origen));
        JOptionPane.showMessageDialog(null, "¡Medicina agregada con éxito!");
    }

    // ------------- OPCIÓN 2 ---------------
    private static void listarMedicinas() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inventario vacío");
            return;
        }
        StringBuilder sb = new StringBuilder("-- Inventario --\n");
        for (int i = 0; i < inventario.size(); i++) {
            sb.append(i + 1).append(". ").append(inventario.get(i)).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // ------------- OPCIÓN 3 ---------------
    private static void eliminarMedicina() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay medicinas para eliminar");
            return;
        }
        listarMedicinas();
        int pos = leerEnteroPositivo("Ingrese el índice a eliminar:") - 1;
        if (pos >= 0 && pos < inventario.size()) {
            Medicina quitada = inventario.remove(pos);
            JOptionPane.showMessageDialog(null, quitada.getNombre() + " eliminada.");
        } else {
            JOptionPane.showMessageDialog(null, "Índice fuera de rango");
        }
    }

    // ------------- OPCIÓN 4 ---------------
    private static void editarMedicina() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay medicinas para editar");
            return;
        }
        listarMedicinas();
        int pos = leerEnteroPositivo("Ingrese índice a editar:") - 1;
        if (pos < 0 || pos >= inventario.size()) {
            JOptionPane.showMessageDialog(null, "Índice fuera de rango");
            return;
        }
        Medicina m = inventario.get(pos);

        String menuEdit = """
                ¿Qué atributo desea modificar?
                1. Nombre
                2. Tipo
                3. Enfermedad que trata
                4. Cantidad
                5. Origen
                6. Cancelar""";
        int eleccion = leerEnteroPositivo(menuEdit);

        switch (eleccion) {
            case 1 -> m.setNombre(JOptionPane.showInputDialog("Nuevo nombre:"));
            case 2 -> m.setTipo(JOptionPane.showInputDialog("Nuevo tipo:"));
            case 3 -> {
                String enf;
                do {
                    enf = JOptionPane.showInputDialog("""
                            Nueva enfermedad (Fiebres, Infecciones,
                            Envenenamientos o Sarpullidos):""");
                } while (!esEnfermedadValida(enf));
                m.setEnfermedad(enf);
            }
            case 4 -> m.setCantidad(leerEnteroPositivo("Nueva cantidad:"));
            case 5 -> m.setOrigen(JOptionPane.showInputDialog("Nuevo origen:"));
            default -> {
                JOptionPane.showMessageDialog(null, "Edición cancelada");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Medicina actualizada");
    }

    // ------------- OPCIÓN 5 ---------------
    private static void atenderPaciente() {
        if (inventario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay medicinas en inventario");
            return;
        }

        int caso = R.nextInt(4) + 1; // 1-4
        String enfermedadRequerida, descripcionCaso;

        switch (caso) {
            case 1 -> {
                enfermedadRequerida = "Fiebres";
                descripcionCaso = "Paciente con fiebre muy alta (Fiebres)";
            }
            case 2 -> {
                enfermedadRequerida = "Infecciones";
                descripcionCaso = "Paciente con pus en la garganta (Infecciones)";
            }
            case 3 -> {
                enfermedadRequerida = "Envenenamientos";
                descripcionCaso = "Paciente con dolor abdominal y vómitos (Envenenamientos)";
            }
            case 4 -> {
                enfermedadRequerida = "Sarpullidos";
                descripcionCaso = "Paciente con erupciones en brazos y piernas (Sarpullidos)";
            }
            default -> throw new AssertionError();
        }

        JOptionPane.showMessageDialog(null, descripcionCaso);
        listarMedicinas();
        int idx = leerEnteroPositivo("Ingrese el índice de la medicina a recetar:") - 1;

        if (idx < 0 || idx >= inventario.size()) {
            JOptionPane.showMessageDialog(null, "Índice fuera de rango. La paciente no fue tratada.");
            return;
        }

        Medicina m = inventario.get(idx);
        if (!m.getEnfermedad().equalsIgnoreCase(enfermedadRequerida)) {
            JOptionPane.showMessageDialog(null,
                    "¡Receta incorrecta! La paciente necesitaba algo para " + enfermedadRequerida
                            + " y recibió " + m.getEnfermedad() + ".");
            return;
        }
        if (m.getCantidad() <= 0) {
            JOptionPane.showMessageDialog(null, "La medicina seleccionada está agotada.");
            return;
        }

        m.setCantidad(m.getCantidad() - 1);
        JOptionPane.showMessageDialog(null,
                "Paciente tratada correctamente con " + m.getNombre()
                        + ". Quedan " + m.getCantidad() + " en inventario.");
    }

    // ------------- UTILIDADES -------------
    private static boolean esEnfermedadValida(String e) {
        return e != null && (e.equalsIgnoreCase("Fiebres")
                || e.equalsIgnoreCase("Infecciones")
                || e.equalsIgnoreCase("Envenenamientos")
                || e.equalsIgnoreCase("Sarpullidos"));
    }

    private static int leerEnteroPositivo(String msg) {
        int n;
        do {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog(msg));
            } catch (Exception e) {
                n = -1;
            }
        } while (n < 0);
        return n;
    }
}









