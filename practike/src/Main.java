
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author angel
 */
public class Main {
    static Random R = new Random();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = menu();
        while (opcion != 4) {
            switch (opcion) {
                case 1:
                    System.out.println("--------- Bingo --------------");
                    int[][] carton1 = GenMatriz();
                    int[][] carton2 = GenMatriz();

                    System.out.println("Carton jugador 1");
                    ImprimirMatriz(carton1);
                    System.out.println();
                    System.out.println("Carton jugador 2");
                    ImprimirMatriz(carton2);
                    System.out.println();

                    boolean hayGanador = false;
                    int rondas = 0;
                    while (!hayGanador) {
                        rondas++;
                        int bola = R.nextInt(10) + 1;
                        System.out.println("Ronda " + rondas + ": se extrajo la bola " + bola);

                        MarcarNumero(carton1, bola);
                        MarcarNumero(carton2, bola);

                        System.out.println("Carton jugador 1");
                        ImprimirMatriz(carton1);
                        System.out.println();
                        System.out.println("Carton jugador 2");
                        ImprimirMatriz(carton2);
                        System.out.println();

                        boolean bingo1 = Bingo(carton1);
                        boolean bingo2 = Bingo(carton2);

                        if (bingo1 || bingo2) {
                            hayGanador = true;
                            if (bingo1 && bingo2) {
                                System.out.println("-- Empateeeee ---");
                            } else if (bingo1) {
                                System.out.println("El jugador 1 ha ganado");
                            } else {
                                System.out.println("El jugador 2 ha ganado");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("----- Codigo Z ---");
                    System.out.print("Ingrese el tamano de la matriz: ");
                    int size = leer.nextInt();
                    while (size < 1 || size > 5) {
                        System.out.println("El tamaño de la matriz tiene que ser entre 1 y 5");
                        System.out.print("Ingrese nuevamente el tamano: ");
                        size = leer.nextInt();
                    }
                    int[][] matrizZ = GenMatrizN(size);
                    System.out.println("Matriz generada:");
                    ImprimirMatriz(matrizZ);
                    int codigo = suma(matrizZ);
                    System.out.println("El codigo secreto (suma de la letra Z) es: " + codigo);
                    break;
                case 3:
                    System.out.println("-------- Rivales Predestinados -------");
                    System.out.print("Ingrese el numero de filas del tablero: ");
                    int filas = leer.nextInt();
                    System.out.print("Ingrese el numero de columnas del tablero: ");
                    int columnas = leer.nextInt();

                    int[][] tablero = GenTablero(filas, columnas);
                    System.out.println("-----Tablero para jugar-----");
                    ImprimirMatriz(tablero);

                    int puntaje1 = 0;
                    int puntaje2 = 0;
                    int tiros = 5;

                    for (int i = 0; i < tiros; i++) {
                        System.out.println("Turno de jugador 1!");
                        puntaje1 += dispararJugador1(tablero);
                        System.out.println("Le quedan :" + (tiros - i - 1) + " balas");

                        System.out.println("Turno de jugador 2!");
                        puntaje2 += dispararJugador2(tablero);
                        System.out.println("Le quedan :" + (tiros - i - 1) + " balas");

                        System.out.println("El tablero:");
                        ImprimirMatriz(tablero);
                    }

                    System.out.println("---- Resultado final --------");
                    if (puntaje1 > puntaje2) {
                        System.out.println("Jugador 1 gana con " + puntaje1);
                        System.out.println("Jugador 2 pierde con " + puntaje2);
                    } else if (puntaje2 > puntaje1) {
                        System.out.println("Jugador 2 gana con " + puntaje2);
                        System.out.println("Jugador 1 pierde con " + puntaje1);
                    } else {
                        System.out.println("Empate con " + puntaje1);
                    }
                    break;
                case 4:
                    System.out.println("Gracias por ver mi programa :(");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo");
            }
            System.out.println();
            opcion = menu();
        }
    }

    public static int menu() {
        System.out.println("***********************************************");
        System.out.println("----------------------- MENU --------------------");
        System.out.println("1. ¡bingo!");
        System.out.println("2. Codigo Z");
        System.out.println("3. Rivales predestinados");
        System.out.println("4. Salida");
        System.out.println("************************************************");
        System.out.print("Ingrese su opcion: ");
        return leer.nextInt();
    }

    public static int[][] GenMatriz() {
        int[][] m = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = 1 + R.nextInt(10);
            }
        }
        return m;
    }

    public static void ImprimirMatriz(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print("[" + x[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public static void MarcarNumero(int[][] carton, int numero) {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (carton[i][j] == numero) {
                    carton[i][j] = 0;
                }
            }
        }
    }

    public static boolean Bingo(int[][] carton) {
        int n = carton.length;
        for (int i = 0; i < n; i++) {
            boolean llena = true;
            for (int j = 0; j < n; j++) {
                if (carton[i][j] != 0) {
                    llena = false;
                    break;
                }
            }
            if (llena) return true;
        }
        for (int j = 0; j < n; j++) {
            boolean llena = true;
            for (int i = 0; i < n; i++) {
                if (carton[i][j] != 0) {
                    llena = false;
                    break;
                }
            }
            if (llena) return true;
        }
        return false;
    }

    public static int suma(int[][] x) {
        int n = x.length;
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += x[0][i];
        }
        for (int j = 1; j < n; j++) {
            suma += x[j][n - 1 - j];
        }
        for (int i = 0; i < n; i++) {
            suma += x[n - 1][i];
        }
        return suma;
    }

    public static int[][] GenMatrizN(int x) {
        int[][] m = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                m[i][j] = 1 + R.nextInt(9);
            }
        }
        return m;
    }

    public static int[][] GenTablero(int x, int c) {
        int[][] m = new int[x][c];
        int max = x * c;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = 1 + R.nextInt(max);
            }
        }
        return m;
    }

    public static int dispararJugador1(int[][] tablero) {
        System.out.print("Elige que numero disparar Jugador 1! ");
        int numero = leer.nextInt();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == numero) {
                    tablero[i][j] = 99;
                    System.out.println("Tiro acertado!");
                    return numero;
                }
            }
        }
        System.out.println("Tiro fallado!");
        return 0;
    }

    public static int dispararJugador2(int[][] tablero) {
        System.out.print("Elige que numero disparar Jugador 2! ");
        int numero = leer.nextInt();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == numero) {
                    tablero[i][j] = 88;
                    System.out.println("Tiro acertado!");
                    return numero;
                }
            }
        }
        System.out.println("Tiro fallado!");
        return 0;
    }
}





