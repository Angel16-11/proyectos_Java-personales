import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class S9_InventarioLibros extends JFrame {
    private static ArrayList<Libreria> libros = new ArrayList<>();
    private static String[][] estante = new String[10][10];
    private JTextArea outputArea = new JTextArea();

    public S9_InventarioLibros() {
        setTitle("Sistema de Gestión de Librería");
        setSize(600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(40, 40, 40));
        setLayout(new BorderLayout());

        inicializarEstante();
        agregarComponentes();
    }

    private void agregarComponentes() {
        JPanel tituloPanel = new JPanel(new GridLayout(2, 1));
        tituloPanel.setBackground(new Color(40, 40, 40));

        JLabel titulo = crearLabel("Librería Central", 24, true);
        JLabel subtitulo = crearLabel("Sistema de Gestión de Libros", 16, false);

        tituloPanel.add(titulo);
        tituloPanel.add(subtitulo);

        JPanel botones = new JPanel(new GridLayout(6, 1, 10, 10));
        botones.setBackground(new Color(40, 40, 40));

        JButton b1 = crearBoton("1. Agregar Libro", this::agregarLibro);
        JButton b2 = crearBoton("2. Eliminar Libro", this::eliminarLibro);
        JButton b3 = crearBoton("3. Listar Libros", this::listarLibros);
        JButton b4 = crearBoton("4. Buscar por Titulo", this::buscarLibro);
        JButton b5 = crearBoton("5. Mostrar Estantería", this::mostrarEstanteria);
        JButton b6 = crearBoton("6. Salir", () -> dispose());

        botones.add(b1);
        botones.add(b2);
        botones.add(b3);
        botones.add(b4);
        botones.add(b5);
        botones.add(b6);

        outputArea.setEditable(false);
        outputArea.setBackground(new Color(30, 30, 30));
        outputArea.setForeground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(outputArea);

        add(tituloPanel, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(60, 60, 60));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.addActionListener(e -> accion.run());
        return boton;
    }

    private JLabel crearLabel(String texto, int size, boolean bold) {
        JLabel label = new JLabel(texto, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", bold ? Font.BOLD : Font.PLAIN, size));
        return label;
    }

    private void inicializarEstante() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                estante[i][j] = "VACIO";
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Título del libro:");
        String autor = JOptionPane.showInputDialog("Autor del libro:");

        if (titulo == null || autor == null || titulo.isEmpty() || autor.isEmpty()) {
            outputArea.setText("Datos inválidos.");
            return;
        }

        String filaStr = JOptionPane.showInputDialog("Fila (1-10):");
        String columnaStr = JOptionPane.showInputDialog("Columna (1-10):");

        if (filaStr == null || columnaStr == null || filaStr.isEmpty() || columnaStr.isEmpty()) {
            outputArea.setText("Fila o columna vacía.");
            return;
        }

        boolean esNumero = true;
        for (int i = 0; i < filaStr.length(); i++) {
            if (!Character.isDigit(filaStr.charAt(i))) {
                esNumero = false;
                break;
            }
        }
        for (int i = 0; i < columnaStr.length(); i++) {
            if (!Character.isDigit(columnaStr.charAt(i))) {
                esNumero = false;
                break;
            }
        }

        if (!esNumero) {
            outputArea.setText("Debe ingresar números válidos.");
            return;
        }

        int fila = Integer.parseInt(filaStr) - 1;
        int columna = Integer.parseInt(columnaStr) - 1;

        if (fila < 0 || fila >= 10 || columna < 0 || columna >= 10) {
            outputArea.setText("Posición fuera de rango.");
            return;
        }

        if (!estante[fila][columna].equals("VACIO")) {
            outputArea.setText("Posición ocupada.");
            return;
        }

        estante[fila][columna] = titulo;
        libros.add(new Libreria(titulo, autor, fila, columna));
        outputArea.setText("Libro agregado en [" + fila + "][" + columna + "]");
    }

    private void eliminarLibro() {
        String titulo = JOptionPane.showInputDialog("Título del libro a eliminar:");
        if (titulo == null || titulo.isEmpty()) {
            outputArea.setText("Título inválido.");
            return;
        }
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                int f = libros.get(i).getFila(), c = libros.get(i).getColumna();
                estante[f][c] = "VACIO";
                libros.remove(i);
                outputArea.setText("Eliminado de [" + f + "][" + c + "]");
                return;
            }
        }
        outputArea.setText("Libro no encontrado.");
    }

    private void listarLibros() {
        if (libros.isEmpty()) {
            outputArea.setText("No hay libros registrados.");
            return;
        }
        String resultado = "";
        for (int i = 0; i < libros.size(); i++) {
            Libreria l = libros.get(i);
            resultado += "Libro " + (i + 1) + ": " + l.getTitulo() + ", " + l.getAutor()
                    + ", [" + l.getFila() + "][" + l.getColumna() + "]\n";
        }
        outputArea.setText(resultado);
    }

    private void buscarLibro() {
        String titulo = JOptionPane.showInputDialog("Título del libro a buscar:");
        if (titulo == null || titulo.isEmpty()) {
            outputArea.setText("Título inválido.");
            return;
        }
        for (Libreria libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                outputArea.setText("Encontrado: " + libro.getTitulo() + ", " +
                        libro.getAutor() + ", [" + libro.getFila() + "][" + libro.getColumna() + "]");
                return;
            }
        }
        outputArea.setText("Libro no encontrado.");
    }

    private void mostrarEstanteria() {
        String resultado = "Estantería:\n\n";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                resultado += "[" + estante[i][j] + "]\t";
            }
            resultado += "\n";
        }
        outputArea.setText(resultado);
    }

    public static void main(String[] args) {
        S9_InventarioLibros ventana = new S9_InventarioLibros();
        ventana.setVisible(true);
    }
}





