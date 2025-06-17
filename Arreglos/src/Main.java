
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner leer = new Scanner(System.in);
    static Random R = new Random();

    public static void main(String[] args) {
        char respuesta = 's';
        while (respuesta == 's' || respuesta == 'S') {
            System.out.println("**********************************************");
            System.out.println("-------------MENU-----------------------------");
            System.out.println("1. Facturación Los Sabrositos");
            System.out.println("2. Producto punto de un vector");
            System.out.println("3. Salir");
            System.out.println("**********************************************");
            System.out.print("Ingrese la opción que va a hacer: ");
            int opcion = leer.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    System.out.println("-- Ejercicio 1: Facturación Los Sabrositos --");
                    System.out.print("Ingrese cuántas mesas hay ocupadas (entre 1 y 20): ");
                    int mesas = leer.nextInt();
                    while (mesas < 1 || mesas > 20) {
                        System.out.println("Solo se pueden facturar entre 1 y 20 mesas.");
                        System.out.print("Ingrese un número válido de mesas: ");
                        mesas = leer.nextInt();
                    }

                    int[] platos = genOrden(mesas);
                    int[] bebidas = genOrden(mesas);

                    System.out.println(imprimirArreglo(platos, "Platos"));
                    System.out.println(imprimirArreglo(bebidas, "Bebidas"));

                    System.out.println("-- Costos del Día --");
                    System.out.println("+ Platos Fuertes = $9.55");
                    System.out.println("+ Bebidas = $3.99");

                    System.out.print("De qué mesa desea generar la Factura: ");
                    int mesa = leer.nextInt();
                    while (mesa < 1 || mesa > mesas) {
                        System.out.println("Ingrese una mesa válida ocupada");
                        System.out.print("De qué mesa desea generar la Factura: ");
                        mesa = leer.nextInt();
                    }

                    int posicionMesa = mesa - 1;
                    double totalPlatos = platos[posicionMesa] * 9.55;
                    double totalBebidas = bebidas[posicionMesa] * 3.99; // Se cambió 'index' por 'posicionMesa'
                    double total = totalPlatos + totalBebidas;

                    System.out.println("---- FACTURA MESA " + mesa + " ----");
                    System.out.println("+ Total Platos Fuertes = $" + totalPlatos);
                    System.out.println("+ Total Bebidas = $" + totalBebidas);
                    System.out.println("Total a Pagar: " + total);
                    System.out.println("Gracias por Visitar Los Sabrositos");
                    break;
                case 2:
                    System.out.println("-- Ejercicio 2: Producto Punto de un Vector --");
                    System.out.print("Ingrese el tamaño de los vectores: ");
                    int tam = leer.nextInt();

                    int[] v1 = new int[tam];
                    int[] v2 = new int[tam];

                    llenarArreglo(v1);
                    llenarArreglo(v2);

                    System.out.println(imprimirArreglo(v1, "Arreglo 1"));
                    System.out.println(imprimirArreglo(v2, "Arreglo 2"));

                    int resultado = productoPunto(v1, v2);
                    System.out.println("El producto punto es: " + resultado);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    respuesta = 'n';
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            if (respuesta != 'n') {
                System.out.print("¿Desea continuar? (s/n): ");
                respuesta = leer.next().charAt(0);
                System.out.println();
            }
        }
    }

    public static int[] genOrden(int tam) {
        int[] arreglo = new int[tam];
        for (int i = 0; i < tam; i++) {
            arreglo[i] = R.nextInt(20) + 1;
        }
        return arreglo;
    }

    public static String imprimirArreglo(int[] arreglo, String nombre) {
        String resultado = nombre + " ---";
        resultado += "[";
        for (int i = 0; i < arreglo.length; i++) {
            resultado += arreglo[i];
            if (i < arreglo.length - 1) {
                resultado += ",";
            }
        }
        resultado += "]";
        return resultado;
    }

    public static void llenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = R.nextInt(101);
        }
    }

    public static int productoPunto(int[] v1, int[] v2) {
        int suma = 0;
        for (int i = 0; i < v1.length; i++) {
            suma += v1[i] * v2[i];
        }
        return suma;
    }
}







