
//grupo:Josue,Angel,Victor;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Josue Garcia
 */
public class Main {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<String> nombres = new ArrayList<String>();
    static ArrayList<String> autores = new ArrayList<String>();
    static ArrayList<Libro> Total = new ArrayList<Libro>();
    static String[][] estanteria = new String[10][10];
    static ArrayList<String> Libros = new ArrayList<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Principal");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println("Bienvenido");
        int op = 1;
        while (op != 5) {
            JPanel panel = new JPanel();
            panel.setBackground(Color.LIGHT_GRAY);
            JButton boton1 = new JButton("1. Agregar Libro");
            JButton boton2 = new JButton("2. Eliminar Libro");
            JButton boton3 = new JButton("3. Listar");
            JButton boton4 = new JButton("4. Buscar Por Título");
            panel.add(boton1);

            panel.add(boton2);
            panel.add(boton3);
            panel.add(boton4);
            frame.add(panel);

            JMenuBar menubar = new JMenuBar();
            JMenu menuarchivo = new JMenu("Archivo");
            JMenuItem itemabrir = new JMenuItem("Abrir");
            JMenuItem itemGuardar = new JMenuItem("Guardar");
            JMenuItem itemSalir = new JMenuItem("Salir");
            menuarchivo.add(itemabrir);
            menuarchivo.add(itemGuardar);
            menuarchivo.add(itemSalir);
            menubar.add(menuarchivo);
            frame.setJMenuBar(menubar);

            if (true){

            }

            op = leer.nextInt();
            leer.nextLine();
            switch (op) {
                case 1:
                    String Nombre = JOptionPane.showInputDialog("Ingrese el nombre del Libro");
                    System.out.println("Ingrese el Autor del Libro: ");
                    String Autor = leer.nextLine();
                    nombres.add(Nombre);
                    autores.add(Autor);
                    Libro cosa = new Libro(Nombre, Autor, 0);
                    Total.add(cosa);
                    System.out.println("En que posicion desea agregar el Libro a la estanteria?");
                    while (true) {
                        System.out.print("Fila de la Estanteria: ");
                        int posx = leer.nextInt();
                        while (posx < 1 || posx > 10) {
                            System.out.println("Ingrese una posición correcta");
                            posx = leer.nextInt();
                        }
                        System.out.print("Columna de la Estantería: ");
                        int posy = leer.nextInt();
                        while (posy < 1 || posy > 10) {
                            System.out.println("Ingrese una posición correcta");
                            posy = leer.nextInt();
                        }
                        if (estanteria[posx - 1][posy - 1] == null) {
                            estanteria[posx - 1][posy - 1] = Nombre;
                            break;
                        } else {
                            System.out.println("Ingrese una posición Vacía");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la Posicion del Libro: ");
                    break;
                case 3:
                    System.out.println("Usted tiene actualmente: " + Total.size() + " Libros");
                    if (Total.isEmpty()) {
                        System.out.println("No existen Libros");
                    } else {
                        System.out.println("\t LISTA DE LIBROS");
                        System.out.println("Nombre "+ "\t"+ "\t" + "Autor");
                        ImprimirLista();

                    }
                    break;
                case 6:
                    System.out.println("Estantería");
                    System.out.println("");
                    Estanteria();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void ImprimirLista() {
        for (int i = 0; i < Total.size(); i++) {
            System.out.println(Total.get(i));
        }
    }

    public static void Estanteria(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(estanteria[i][j]+"\t");
            }
            System.out.println("");
        }
    }

    public static void Interfaz(){
    }
}