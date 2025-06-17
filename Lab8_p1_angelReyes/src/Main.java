
import java.util.Scanner;   // leer
import java.util.Random;    // R
import java.util.ArrayList; // ArrayList

public class Main {

    static Scanner  leer    = new Scanner(System.in);
    static Random   R       = new Random();
    static ArrayList<Cita>    citas   = new ArrayList<>();
    static ArrayList<Integer> tiempos = new ArrayList<>();

    public static void main(String[] args) {

        char respuesta = 's';
        do {
            System.out.println("***********************************************");
            System.out.println("---------------------MENU----------------------");
            System.out.println("1.Petalia's Beauty Booking");
            System.out.println("2.Cinderella's Escape plan");
            System.out.println("3.Record de escape ");
            System.out.println("4.Salir");
            System.out.println("************************************************");
            System.out.print("Que opcion desea hacer: ");
            int opcion = leer.nextInt();

            switch (opcion) {
                /* ----------- CASO 1: Citas ----------- */
                case 1 -> {
                    char resp = 's';
                    do {
                        System.out.println("************************************");
                        System.out.println("----------MENU DE Petalia's----------");
                        System.out.println("1.Agendar nueva cita");
                        System.out.println("2.Listar");
                        System.out.println("3.Eliminar");
                        System.out.println("4.Modificar");
                        System.out.println("************************************");
                        System.out.print("Ingrese su opcion: ");
                        int op = leer.nextInt();

                        switch (op) {
                            case 1 -> agregarCita();
                            case 2 -> listarCitas();
                            case 3 -> eliminarCita();
                            case 4 -> modificarCita();
                            default -> System.out.println("Su opcion es incorrecta!!");
                        }
                        System.out.print("Desea seguir en citas (s/n): ");
                        resp = leer.next().charAt(0);
                    } while (resp == 's' || resp == 'S');
                    break;                                // <<-- FIX: evita caer al caso 2
                }

                /* ----------- CASO 2: Escape ----------- */
                case 2 -> {
                    char[][] tablero = new char[5][5];
                    inicializarTablero(tablero);
                    colocarObstaculos(tablero);
                    int tiempo = jugarEscape(tablero);
                    if (tiempo != -1) {
                        tiempos.add(tiempo);
                    }
                }

                /* ----------- CASO 3: Tiempos ----------- */
                case 3 -> mostrarTiempos();

                case 4 -> {
                    System.out.println("Fin del programa.");
                    return;                               // <<-- FIX: sale del main
                }

                default -> System.out.println("Su opcion es incorrecta!!");
            }
            System.out.print("¿Volver al menú principal? (s/n): "); // <<-- FIX
            respuesta = leer.next().charAt(0);                      // <<-- FIX
        } while (respuesta == 's' || respuesta == 'S');
    }

    /* ========== CRUD DE CITAS ========== */

    public static void agregarCita() {
        leer.nextLine();                             // <<-- FIX: limpia salto pendiente
        System.out.print("Cliente: ");
        String cliente = leer.nextLine();
        System.out.print("Servicio: ");
        String servicio = leer.nextLine();
        System.out.print("Fecha: ");
        String fecha = leer.nextLine();
        System.out.print("Estado: ");
        String estado = leer.nextLine();

        citas.add(new Cita(cliente, servicio, fecha, estado));
        System.out.println("✔ Cita agregada.");
    }

    public static void listarCitas() {
        if (citas.isEmpty()) {
            System.out.println("No hay citas.");
        } else {
            for (int i = 0; i < citas.size(); i++) {
                System.out.println(i + ", " + citas.get(i));
            }
        }
    }

    public static void eliminarCita() {
        listarCitas();
        if (!citas.isEmpty()) {
            System.out.print("Indice: ");
            int indice = leer.nextInt();
            if (indice >= 0 && indice < citas.size()) {
                citas.remove(indice);
                System.out.println("Eliminada!!");
            } else {
                System.out.println("Fuera del rango permitido");
            }
        }
    }

    public static void modificarCita() {
        listarCitas();
        if (!citas.isEmpty()) {
            System.out.print("Indice: ");
            int ind = leer.nextInt();
            if (ind >= 0 && ind < citas.size()) {
                leer.nextLine();                      // <<-- FIX limpia buffer
                System.out.print("Nuevo cliente: ");
                String cli = leer.nextLine();
                System.out.print("Nuevo servicio: ");
                String servicio = leer.nextLine();
                System.out.print("Nueva fecha: ");
                String fecha = leer.nextLine();
                System.out.print("Nuevo estado: ");
                String estado = leer.nextLine();

                /* Reemplaza la cita vieja sin usar setters */
                citas.remove(ind);                    // quita la vieja
                citas.add(ind, new Cita(cli, servicio, fecha, estado)); // pone la nueva
                System.out.println("Cambiado");
            } else {
                System.out.println("No estás en el rango");
            }
        }
    }

    /* ========== JUEGO ========== */

    public static void inicializarTablero(char[][] x) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                x[i][j] = ' ';
            }
        }
    }

    public static void colocarObstaculos(char[][] x) {
        int puesto = 0;
        while (puesto < 9) {
            int f = R.nextInt(5);
            int c = R.nextInt(5);
            if (!(f == 0 && c == 0) && x[f][c] == ' ') {
                if (puesto < 3) {
                    x[f][c] = 'M';
                } else if (puesto < 6) {
                    x[f][c] = 'R';
                } else {
                    x[f][c] = 'H';
                }
                puesto++;
            }
        }
    }

    public static int jugarEscape(char[][] tablero) {
        int fila = 0, col = 0, tiempo = 0;
        tablero[fila][col] = 'C';

        while (fila != 4 || col != 4) {
            tiempo += 1 + R.nextInt(10);
            if (tiempo >= 60) {
                System.out.println("Pasaron 60 min, perdiste.");
                return -1;
            }
            int pasos = 1 + R.nextInt(5);
            int pos = fila * 5 + col + pasos;
            boolean avanza = true;

            if (pos / 5 < 5) {
                char celda = tablero[pos / 5][pos % 5];
                if (celda == 'M') {
                    System.out.println("Madrastra. No avanzas");
                    avanza = false;
                } else if (celda == 'R') {
                    pos += 1;
                    System.out.println("Ratón +1");
                } else if (celda == 'H') {
                    pos += 3;
                    System.out.println("Hada madrina +3");
                }
            }
            if (avanza) {
                if (pos > 24) pos = 24;
                tablero[fila][col] = ' ';
                fila = pos / 5;
                col = pos % 5;
                tablero[fila][col] = 'C';
                imprimirTablero(tablero);
                System.out.println("Tiempo: " + tiempo + " min\n");
            }
        }
        System.out.println("Escapaste en: " + tiempo + " min");
        return tiempo;
    }

    public static void imprimirTablero(char[][] m) {
        for (char[] fila : m) {
            for (char cel : fila) System.out.print("[" + cel + "]");
            System.out.println();
        }
    }

    /* ========== TIEMPOS ========== */

    public static void mostrarTiempos() {
        if (tiempos.isEmpty()) {
            System.out.println("sin registro");
        } else {
            int record = tiempos.get(0);          // toma el primero como base
            System.out.println("Tiempos:");

            for (int t : tiempos) {               // recorre cada tiempo
                System.out.println("- " + t + " min");   // ← guion y espacio
                if (t < record) {
                    record = t;                   // actualiza récord
                }
            }

            System.out.println("Record: " + record + " min"); // se muestra una sola vez
        }
    }

}




